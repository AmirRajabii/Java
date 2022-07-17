package com.shamsipour.allinonebot.model;

import org.telegram.telegrambots.meta.api.objects.Update;

public class BotInfoModel {
	private String botId = "Allin_one_Robot";
	private String botToken = "5482114459:AAHF2cMLTPB53hXe-MuJk1atsfh0Mr4EUoY";

	public String getBotId() {
		return botId;
	}

	public String getBotToken() {
		return botToken;
	}

	public String wlecomeMessage(Update update) {
		return "سلام " + update.getMessage().getFrom().getFirstName() + " عزیز به ربات آلین وان خوش اومدی 😍\n \n"
				+ " از قسمت پایین فعالیت مورد نظر خودتون رو انتخاب کنید 👇"
				;
	}

}
