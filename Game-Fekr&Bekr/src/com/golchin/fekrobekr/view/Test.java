package com.golchin.fekrobekr.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
	class Cat {
		public String name;
		public int age;
	}

	public static void main(String[] args) {
		// System.out.println(IntStream.of(new int[] { 2, 5, 8 }).anyMatch(x -> x ==
		// 5));
		// List.of(1).stream().forEach(c -> {
		// System.out.println(c);
		// });

		List<Cat> cats = new ArrayList<>();
		cats.stream().map(c -> c.age).filter(a -> a > 2).forEach(System.out::print);

		String str = "1234";
		Integer[] ints = str.chars().mapToObj(c -> Integer.valueOf((char) c + "")).collect(Collectors.toList())
				.toArray(new Integer[str.length()]);
		for (Integer integer : ints) {
			System.out.println(integer);
		}

	}

}
