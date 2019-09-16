package com.edpas.java8.c.methodReference;

import java.util.Arrays;
import java.util.Comparator;

public class MethodReference {

	private static void referenceStaticMethod() {
		System.out.println("Static Method Reference");
	}

	private String[] getStates() {
		String[] states = {"Texas", "Washington", "Arkansas"};
		return states;
	}
	
	private void referenceMethodAnyInstance() {
		// JDK <= 7
		String[] copy1 = this.getStates();
		System.out.println("JDK <= 7:");
		Arrays.sort(copy1, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);
			}			
		});
		System.out.println(Arrays.toString(copy1));	
		System.out.println();
		
		// Lambda Expression	
		String[] copy2 = this.getStates();
		System.out.println("Lambda Expression:");
		Arrays.sort(copy2, (o1, o2) -> o1.compareToIgnoreCase(o2));
		System.out.println(Arrays.toString(copy2));
		System.out.println();
		
		// Method reference
		String[] copy3 = this.getStates();
		System.out.println("Method Reference:");
		Arrays.sort(copy3, String::compareToIgnoreCase);
		System.out.println(Arrays.toString(copy3));
		System.out.println();
	}
	
	private void referenceMethodSpecificInstance() {
		System.out.println("Method Reference from Specific Instance");
		System.out.println();
	}
	
	private void referenceConstructor() {
		// JDK <= 7
		System.out.println("JDK <= 7:");
		IPerson iPerson1 = new IPerson() {
			@Override
			public Person create(int id, String name) {
				return new Person(id, name);
			}
		};
		Person person1 = iPerson1.create(1, "JDK 7");
		System.out.println(person1.getId() + " - " + person1.getName());
		System.out.println();
			 			
		// Lambda Expression
		System.out.println("Lambda Expression:");
		IPerson iPerson2 = (x, y) -> (new Person(x, y));
		Person person2 = iPerson2.create(2, "Lambda Expression");
		System.out.println(person2.getId() + " - " + person2.getName());
		System.out.println();

		// Method reference
		System.out.println("Method Reference:");
		IPerson iPerson3 = Person::new;
		Person person3 = iPerson3.create(3, "Method Reference");
		System.out.println(person3.getId() + " - " + person3.getName());
		System.out.println();
	}
	
	private void process() {
		// Lambda Expression
		System.out.println("Lambda Expression:");
		IAuxiliar auxiliar = () -> MethodReference.referenceStaticMethod();
		auxiliar.process();	
		System.out.println();
		
		// Method reference
		System.out.println("Method Reference:");
		IAuxiliar auxiliar2 = MethodReference::referenceStaticMethod;
		auxiliar2.process();
		System.out.println();
	}
	
	public static void main(String[] args) {
		MethodReference references = new MethodReference();
		references.process();
		
		references.referenceMethodAnyInstance();
		
		IAuxiliar auxiliar = references::referenceMethodSpecificInstance;
		auxiliar.process();
		
		references.referenceConstructor();
	}
}