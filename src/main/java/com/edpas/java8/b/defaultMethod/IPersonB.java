package com.edpas.java8.b.defaultMethod;

public interface IPersonB {

	default public void bye() {
		System.out.println("Good bye!!! - PersonB");
	}
}
