package com.edpas.java8.e.stream;

import java.util.ArrayList;
import java.util.List;

public class Stream {

	private List<String> getStates() {
		List<String> states = new ArrayList<String>();
		states.add("Texas");
		states.add("Washington");
		states.add("Colorado");
		states.add("Arkansas");
		return states;
	}
	
	private List<List<String>> getStatesByZone() {
		List states = new ArrayList();
				
		List<String> east = new ArrayList<String>();
		east.add("Florida");
		east.add("Georgia");
		east.add("New York");
		states.add(east);
		
		List<String> central = new ArrayList<String>();
		central.add("Texas");
		central.add("Kansas");
		central.add("Colorado");
		states.add(central);
		
		List<String> west = new ArrayList<String>();
		central.add("California");
		central.add("Nevada");
		central.add("Washington");
		states.add(west);
		
		return states;
	}
	
	private void useFilter() {
		System.out.println("Method useFilter:");
		List<String> states = this.getStates();
		states.stream().filter(x -> x.contains("n")).forEach(System.out::println);
		System.out.println();
	}
	
	private void useSorted() {
		System.out.println("Method useSort:");
		List<String> states = this.getStates();
		System.out.println("ASC:");
		states.stream().sorted().forEach(System.out::println);
		System.out.println("DESC:");
		states.stream().sorted((x, y) -> y.compareTo(x)).forEach(System.out::println);
		System.out.println();
	}
	
	private void useMap() {
		System.out.println("Method useMap:");
		List<String> states = this.getStates();
		states.stream().map(String::toUpperCase).forEach(System.out::println);
		System.out.println();
	}
	
	private void useFlatMap() {
		System.out.println("Method useFlatMap:");
		List<List<String>> states = this.getStatesByZone();
		states.stream().flatMap(List::stream).sorted().forEach(System.out::println);
		System.out.println();
	}
	
	private void useLimit() {
		System.out.println("Method useLimit:");
		List<String> states = this.getStates();
		states.stream().limit(2).forEach(System.out::println);
		System.out.println();
	}
	
	private void useCount() {
		System.out.println("Method useCount:");
		List<String> states = this.getStates();
		System.out.println(states.stream().count());
		System.out.println();
	}
	
	public static void main(String[] args) {
		Stream stream = new Stream();
		stream.useFilter();
		stream.useSorted();
		stream.useMap();
		stream.useFlatMap();
		stream.useLimit();
		stream.useCount();
	}
}
