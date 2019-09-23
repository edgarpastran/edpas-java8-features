package com.edpas.java8.a.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExpression1 {

	private List<String> getStates() {
		List<String> states =  new ArrayList<String>();
		states.add("Texas");
		states.add("Washington");
		states.add("Arkansas");		
		return states;
	}
	
	private void orderWithJava7() {
		System.out.println("JDK <= 7:");
		List<String> states = this.getStates();
		Collections.sort(states, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) { 
				return o1.compareTo(o2);
			}		
		});
		
		for (String element: states) {
			System.out.println(element);
		}
		
		System.out.println();
	}
	
	private void orderWithJava8() {
		System.out.println("Lambda Expression:");
		List<String> states = this.getStates();
		Collections.sort(states, (String p1, String p2) -> p1.compareTo(p2));
		states.forEach(x -> System.out.println(x));
		
		System.out.println();
	}
	
	public void order(int version) {
		if (version <= 7) {
			this.orderWithJava7();
		}
		else {
			this.orderWithJava8();
		}		
	}
	
	public static void main(String[] args) {
		LambdaExpression1 lambda = new LambdaExpression1();
		lambda.order(7);
		lambda.order(8);		
	}
}
