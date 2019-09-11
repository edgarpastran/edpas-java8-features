package com.edpas.java8.b.defaultMethod;

public class DefaultMethod implements IPersonA, IPersonB {
	
	private String personKind;
	
	@Override
	public void greeting() {
		System.out.println("Hello!!!");
	}

	@Override
	public void bye() {
		if (personKind.equals("A")) {
			IPersonA.super.bye();
			System.out.println("See you tomorrow!!!");
		}
		else {
			IPersonB.super.bye();
			System.out.println("Have a good day!!!");
		}		
	}

	public static void main(String[] args) {
		DefaultMethod defaultMethod = new DefaultMethod();
		defaultMethod.greeting();
		System.out.println();
		defaultMethod.personKind = "A";
		defaultMethod.bye();
		System.out.println();
		defaultMethod.personKind = "B";
		defaultMethod.bye();
	}
}
