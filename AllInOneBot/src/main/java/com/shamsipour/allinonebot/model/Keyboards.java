package com.shamsipour.allinonebot.model;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

public class Keyboards {
	public static ReplyKeyboardMarkup getMainMenuKeyboard() {
		ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
		replyKeyboardMarkup.setSelective(true);
		replyKeyboardMarkup.setResizeKeyboard(true);
		replyKeyboardMarkup.setOneTimeKeyboard(false);
		List<KeyboardRow> keyboard = new ArrayList<>();
		KeyboardRow keyboardFirstRow = new KeyboardRow();
		keyboardFirstRow.add("💰 قیمت ارزهای دیجیتال 💰");
		KeyboardRow keyboardSecondRow = new KeyboardRow();
		keyboardSecondRow.add("⛅️ آب و هوا ⛅️");
		keyboardSecondRow.add("⭐️ قیمت طلا ⭐️");
		KeyboardRow keyboardRow3 = new KeyboardRow();
		keyboardRow3.add("درباره ما");
		KeyboardRow keyboardRow4 = new KeyboardRow();
		keyboardRow4.add("👁‍🗨 ساخت Qrcode 👁‍🗨");
		keyboard.add(keyboardFirstRow);
		keyboard.add(keyboardSecondRow);
		keyboard.add(keyboardRow4);
		keyboard.add(keyboardRow3);
		replyKeyboardMarkup.setKeyboard(keyboard);

		return replyKeyboardMarkup;
	}

	public static ReplyKeyboardMarkup getWeatherSubMenuKeyboard() {
		ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
		replyKeyboardMarkup.setSelective(true);
		replyKeyboardMarkup.setResizeKeyboard(true);
		replyKeyboardMarkup.setOneTimeKeyboard(false);
		List<KeyboardRow> keyboard2 = new ArrayList<>();
		KeyboardRow keyboardSecondRow = new KeyboardRow();
		keyboardSecondRow.add("⛅️ آب و هوای امروز ⛅️");
		keyboardSecondRow.add("⛅️ آب و هوای ۱۰ روز آینده ⛅️ ");
		KeyboardRow keyboardRow3 = new KeyboardRow();
		keyboardRow3.add("🏠 منو اصلی 🏠");
		keyboard2.add(keyboardSecondRow);
		keyboard2.add(keyboardRow3);
		replyKeyboardMarkup.setKeyboard(keyboard2);
		return replyKeyboardMarkup;
	}

}
