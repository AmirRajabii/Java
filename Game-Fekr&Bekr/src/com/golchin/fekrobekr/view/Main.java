package com.golchin.fekrobekr.view;

import java.util.Arrays;
import java.util.Scanner;

import com.golchin.fekrobekr.business.logic.GameLogic;

public class Main {

	public static void main(String[] args) {
		System.out.print("Enter Guess Count : ");
		int tRowHads = new Scanner(System.in).nextInt();
		System.out.print("Enter Number Count : ");
		int tAdad = new Scanner(System.in).nextInt();
		System.out.println("------------");
		int[] rndNumber = GameLogic.getRandomNumber(tAdad);
		String[] tHads = GameLogic.ChekHads(hadsArray(tAdad), rndNumber);
		for (int i : rndNumber) {
			System.out.print(i);
		}
		System.out.println();
		int co = 1;
		while (co++ <= tRowHads) {
			printHads(tHads);
			tHads = GameLogic.ChekHads(hadsArray(tAdad), rndNumber);
			if (GameLogic.winOrLose(tHads)) {
				System.out.println(" !!! You Win !!! ");
				break;
			} else if (!GameLogic.winOrLose(tHads) && co == tRowHads) {
				System.out.println(" !!! You Lose !!! ");
				break;
			}
		}

	}

	public static void printHads(String[] hads) {
		Arrays.asList(hads).forEach(e -> {
			System.out.print(e + "\t");
		});
		System.out.println();
	}

	public static int[] hadsArray(int noAdad) {
		int[] numbers = new int[noAdad];
		System.out.print("Enter Your Guess : ");
		String num = new Scanner(System.in).next();
		for (int i = 0; i < noAdad; i++) {
			numbers[i] = num.charAt(i) - 48;
		}
		return numbers;
	}

}
