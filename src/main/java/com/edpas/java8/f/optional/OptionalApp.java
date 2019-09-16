package com.edpas.java8.f.optional;

import java.util.Optional;

public class OptionalApp {

	public void test(String value) {	
		System.out.println("Method test:");
		try{
			Optional op = Optional.empty();
			op.get();						
		}
		catch(Exception e){
			System.out.println("Element not found");
		}		
		System.out.println();
	}
	
	public void orElse(String value) {
		System.out.println("Method orElse:");
		Optional<String> op = Optional.ofNullable(value);
		String x = op.orElse("default");
		System.out.println(x);
		System.out.println();
	}
	
	public void orElseThrow(String value) {
		System.out.println("Method orElseThrow:");
		Optional<String> op = Optional.ofNullable(value);
		try {
			String x = op.orElseThrow(NumberFormatException::new);
			System.out.println(x);
		}
		catch(Exception e){
			System.out.println(e.toString());
		}		
		System.out.println();
	}
	
	public void isPresent(String value) {
		System.out.println("Method isPresent:");
		Optional<String> op = Optional.ofNullable(value);
		System.out.println(op.isPresent());
		System.out.println();
	}
	
	public static void main(String[] args) {
		OptionalApp app = new OptionalApp();
		app.test("Texas");
		app.orElse("Texas");
		app.orElse(null);
		app.orElseThrow("Texas");
		app.orElseThrow(null);
		app.isPresent("Texas");
		app.isPresent(null);
	}
}
