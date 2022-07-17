package com.shamsipour.allinonebot.business;

import java.io.File;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.shamsipour.allinonebot.model.BotInfoModel;
import com.shamsipour.allinonebot.model.Keyboards;

public class BotHandeler extends TelegramLongPollingBot {
	BotInfoModel botInfoModel = new BotInfoModel();
	Update update;

	public void onUpdateReceived(Update update) {
		this.update = update;
		if (update.hasMessage()) {
			Message message = update.getMessage();
			if (message.hasText() || message.hasLocation()) {
				try {
					handleIncomingMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

		}
	}

	private void handleIncomingMessage(Message message) throws TelegramApiException {

		answerUser(message);
	}

	private void answerUser(Message message) {

		ReplyKeyboardMarkup replyKeyboardMarkupMainMenu = Keyboards.getMainMenuKeyboard();
		ReplyKeyboardMarkup replyKeyboardMarkupWeather = Keyboards.getWeatherSubMenuKeyboard();
		SendMessage sendMessageRequest = new SendMessage();

		if (replyKeyboardMarkupMainMenu != null) {
			sendMessageRequest.setReplyMarkup(replyKeyboardMarkupMainMenu);
		}

		if (message.hasText()) {

			sendMessageRequest.setChatId(message.getChatId().toString());

			String userMessage = message.getText();
			if (userMessage == "⛅️ آب و هوا ⛅️") {
				if (replyKeyboardMarkupWeather != null) {
					sendMessageRequest.setReplyMarkup(replyKeyboardMarkupWeather);
				}
				sendMessageRequest.setText("👇 لطفا یکی از موارد زیر را انتخاب کنید 👇");
			} else if (userMessage == "💰 قیمت ارزهای دیجیتال 💰") {

				sendMessageRequest.setText("💰 قیمت ارزهای دیجیتال 💰");
			} else if (userMessage == "⭐️ قیمت طلا ⭐️") {

				sendMessageRequest.setText("⭐️ قیمت طلا ⭐️");
			} else if (userMessage == "👁‍🗨 ساخت Qrcode 👁‍🗨") {
				sendMessageRequest.setText("برای ساخت Qrcode با شکل زیر عمل کنید 👇\n" + "\n"
						+ "/qr لینک یا متن مورد نظر\n" + "\n" + "چند لحظه پس از ارسال عکس Qrcode شما ارسال خواهد شد ✅");
			} else if (update.getMessage().getText().contains("/qr ")) {
				String qrcodeText = update.getMessage().getText().replace("/qr", "");
				QrCodeGenerator.getQrcodeData(qrcodeText);
				Long userId = update.getMessage().getFrom().getId();
				SendPhoto sendPhoto = new SendPhoto();
				sendPhoto.setChatId(userId.toString());
				sendPhoto.setPhoto(new InputFile(new File("./Quote.png")));
				try {
					execute(sendPhoto);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			} else if (userMessage == "درباره ما") {

				sendMessageRequest.setText(
						"\u200C\u200Cما در زمینه\u200Cی طراحی و توسعه\u200Cی وب فارسی فعال هستیم. نشاط، انگیزه و نوآوری اولین چیزی\u200Cست که از تیم ما به چشم می\u200Cخورد. موضوع اصلی فعالیت ما تولید پوسته\u200Cهای ایرانی برای سیستم وردپرس است. همچنین برنامه نویسی، طراحی سایت، خدمات میزبانی و ... از جمله خدمات ماست.");
			} else if (userMessage == "🏠 منو اصلی 🏠") {
				sendMessageRequest.setReplyMarkup(replyKeyboardMarkupMainMenu);
				sendMessageRequest.setText(" به منو اصلی بازگشتید");
			} else if (userMessage == "/start") {
				sendMessageRequest.setText(botInfoModel.wlecomeMessage(update));
			}
//			else {
//				sendMessageRequest.setText("❌ مقدار اشتباه وارد شده است لطفا از دکمه ها استفاده کنید ❌");
//			}
		}
		try {
			execute(sendMessageRequest);
		} catch (TelegramApiException e) {
			sendMessageRequest.setText("Wrong Command");
		}
	}

	// Bot Config --------------------------------------------------

	public String getBotUsername() {
		return botInfoModel.getBotId();
	}

	@Override
	public String getBotToken() {
		return botInfoModel.getBotToken();
	}
	// --------------------------------------------------------------
}
