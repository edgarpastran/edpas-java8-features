package com.edpas.java8.e.stream;

import java.util.ArrayList;
import java.util.List;

public class ParallelStream {

	private List<Integer> numbers;

	public void fill() {

		this.numbers = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			this.numbers.add(i);
		}
	}

	public void testStream() {
		System.out.println("Method testStream");
		this.numbers.stream().forEach(System.out::println);
		System.out.println();
	}

	public void testParallelStream() {
		System.out.println("Method testParallelStream");
		this.numbers.parallelStream().forEach(System.out::println);
		System.out.println();
	}

	public static void main(String[] args) {
		ParallelStream app = new ParallelStream();

		app.fill();
		app.testStream();
		app.testParallelStream();
	}
}
