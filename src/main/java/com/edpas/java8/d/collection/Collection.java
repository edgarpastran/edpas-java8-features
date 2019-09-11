package com.edpas.java8.d.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Collection {

	private List<String> getStates() {
		List<String> states = new ArrayList<String>();
		states.add("Texas");
		states.add("Washington");
		states.add("Arkansas");
		return states;
	}
	
	private void useForEach() {
		System.out.println("Method useForEach");
		
		// JDK <= 1.7
		System.out.println("JDK <= 1.7:");
		for (String state: this.getStates()) {
			System.out.println(state);
		}
		
		// Lambda Expression
		System.out.println("Lambda Expression:");
		this.getStates().forEach(x -> System.out.println(x));
		
		// Method Reference
		System.out.println("Method Reference:");
		this.getStates().forEach(System.out::println);
		
		System.out.println();
	}
	
	private void useRemoveIf() {
		System.out.println("Method useRemoveIf");
		
		// JDK <= 1.7
		System.out.println("JDK <= 1.7:");
		List<String> copy1 = this.getStates();
		Iterator<String> iterator = copy1.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().equalsIgnoreCase("Arkansas")) {
				iterator.remove();
			}
		}
		System.out.println(copy1.toString());
		
		// Lambda Expression
		System.out.println("Lambda Expression:");
		List<String> copy2 = this.getStates();
		copy2.removeIf(x -> x.equalsIgnoreCase("Arkansas"));
		System.out.println(copy2.toString());
		
		System.out.println();
	}
	
	private void useSort() {
		System.out.println("Method useSort");
		
		// JDK <= 1.7
		System.out.println("JDK <= 1.7:");
		List<String> copy1 = this.getStates();
		Collections.sort(copy1, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println(copy1.toString());
		
		// Lambda Expression
		System.out.println("Lambda Expression:");
		List<String> copy2 = this.getStates();
		copy2.sort((x, y) -> x.compareTo(y));
		System.out.println(copy2.toString());
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		Collection collection = new Collection();
		collection.useForEach();
		collection.useRemoveIf();
		collection.useSort();
	}
}
