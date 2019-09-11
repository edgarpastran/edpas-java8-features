package com.edpas.java8.b.defaultMethod;

public interface IPersonA {

	public void greeting();
	
	default public void bye() {
		System.out.println("Good bye!!! - PersonA");
	}
}
