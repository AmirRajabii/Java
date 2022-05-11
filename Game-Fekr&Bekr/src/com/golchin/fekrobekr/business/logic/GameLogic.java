package com.golchin.fekrobekr.business.logic;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class GameLogic {

	public static int[] getRandomNumber(int no) {
		return ThreadLocalRandom.current().ints(0, 9).distinct().limit(no).toArray();
	}

	public static String[] ChekHads(int[] hads, int[] randomNumbers) {
		String[] result = new String[randomNumbers.length];
		int[] j = { 0 };
		for (int i = 0; i < randomNumbers.length; i++) {
			j[0] = i;

			if (hads[i] == randomNumbers[i]) {
				result[i] = "T";
			} else if (IntStream.of(randomNumbers).anyMatch(x -> x == hads[j[0]])) {
				result[i] = "NT";
			} else {
				result[i] = "F";
			}
		}
		return result;

	}

	public static boolean winOrLose(String[] cheked) {
		return Arrays.stream(cheked).allMatch(i -> i == "T");
	}

}
