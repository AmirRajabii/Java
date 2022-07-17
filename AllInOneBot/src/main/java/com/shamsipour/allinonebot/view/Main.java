package com.shamsipour.allinonebot.view;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import com.shamsipour.allinonebot.business.BotHandeler;

public class Main {

	public static void main(String[] args) {

//		ObjectMapper mapper = new ObjectMapper();
//		try {
//			String jsonValue = "{\"coord\":{\"lon\":51.4215,\"lat\":35.6944},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"base\":\"stations\",\"main\":{\"temp\":31.73,\"feels_like\":29.53,\"temp_min\":27.79,\"temp_max\":31.99,\"pressure\":1014,\"humidity\":11},\"visibility\":10000,\"wind\":{\"speed\":2.06,\"deg\":30},\"clouds\":{\"all\":0},\"dt\":1658032504,\"sys\":{\"type\":2,\"id\":47737,\"country\":\"IR\",\"sunrise\":1658021449,\"sunset\":1658072978},\"timezone\":16200,\"id\":112931,\"name\":\"Tehran\",\"cod\":200}";
//			Model convertedList = mapper.readValue(jsonValue, new TypeReference<Model>() {
//			});
//
//			System.out.println(convertedList.temp);
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		try {
			TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
			telegramBotsApi.registerBot(new BotHandeler());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
		System.out.println("--- Bot Started ---");
	}

	static class Model {
		public float temp;
		public String description;
		public String icon;
		public Long sunrise;
		public Long sunset;

		public Model() {
			super();
		}

		public Model(float temp, String description, String icon, Long sunrise, Long sunset) {
			super();
			this.temp = temp;
			this.description = description;
			this.icon = icon;
			this.sunrise = sunrise;
			this.sunset = sunset;
		}

	}
}