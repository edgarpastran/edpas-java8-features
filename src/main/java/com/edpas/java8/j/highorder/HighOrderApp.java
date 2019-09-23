package com.edpas.java8.j.highorder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class HighOrderApp {

	private Function<String, String> convertToUpperCase = x -> x.toUpperCase();
	private Function<String, String> convertToLowerCase = x -> x.toLowerCase();
	
	
	private List<String> getStates() {
		List<String> states = new ArrayList<String>();
		states.add("Texas");
		states.add("Washington");
		states.add("Florida");
		states.add("Arkansas");
		return states;
	}
	
	private void print(Function<String, String> function, String value) {
		System.out.println(function.apply(value));
	}
	
	private Function<String, String> show(String message) {
		return (String x) -> message + x;
	}
	
	private void filterByLength(List<String> list, Consumer<String> consumer, int length) {
		list.stream().filter(this.getLogicalFilterByLength(length)).forEach(consumer);
	}
	
	private Predicate<String> getLogicalFilterByLength(int length) {
		return x -> x.length() <= length;
	}
	
	private void filterBySubstring(List<String> list, Consumer<String> consumer, String substring) {
		list.stream().filter(this.getLogicalFilterBySubstring(substring)).forEach(consumer);
	}
	
	private Predicate<String> getLogicalFilterBySubstring(String substring) {
		return x -> x.contains(substring);
	}
	
	public static void main(String[] args) {
		HighOrderApp app = new HighOrderApp();
		
		System.out.println("First Functions:");
		String value = "Java 8";
		app.print(app.convertToLowerCase, value);
		app.print(app.convertToUpperCase, value);
		System.out.println();
		
		System.out.println("Second Function:");
		String result = app.show("Hello ").apply("World!!!");
		System.out.println(result);
		System.out.println();
		
		System.out.println("Third Function:");
		app.filterByLength(app.getStates(), System.out::println, 7);
		System.out.println();
		
		System.out.println("Fourth Function:");
		app.filterBySubstring(app.getStates(), System.out::println, "n");
		System.out.println();
	}
}
