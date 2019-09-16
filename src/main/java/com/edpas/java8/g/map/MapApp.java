package com.edpas.java8.g.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MapApp {

	private Map<Integer, String> states;
	
	private void fillStates() {
		this.states = new HashMap<Integer, String>();
		this.states.put(1, "Texas");
		this.states.put(2, "Washington");
		this.states.put(3, "Arkansas");
		
	}
	
	private void showStatesWithJava7() {		
		for (Entry<Integer, String> entry: this.states.entrySet()) {
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
		System.out.println();
	}
	
	private void showStatesWithJava8(int way) {
		if (way == 1) {
			// Way 1			
			this.states.forEach((k, v) -> System.out.println(k+"="+v));
		}
		else {
			// Way 2			
			this.states.entrySet().stream().forEach(System.out::println);
		}
	}
	
	private void showStates(int version) {
		if (version <= 7) {
			System.out.println("JDK <= 7:");
			this.showStatesWithJava7();
		}
		else {
			System.out.println("JDK = 8:");
			System.out.println("Way 1:");
			this.showStatesWithJava8(1);
			System.out.println("Way 2:");
			this.showStatesWithJava8(2);
		}
		System.out.println();
	}
	
	private void usePutIfAbasent() {
		System.out.println("Method usePutIfAbasent:");
		this.states.putIfAbsent(2, "Colorado");
		this.states.putIfAbsent(4, "Florida");
		this.showStatesWithJava8(2);
		System.out.println();
	}
	
	private void useComputeIfPresent() {
		System.out.println("Method useComputeIfPresent:");
		this.states.computeIfPresent(4, (k,v) -> v+" State");
		this.showStatesWithJava8(2);
		System.out.println();
	}
	
	private void useGetOrDefault() {
		System.out.println("Method useGetOrDefault:");
		Integer[] k = {1, 5};
		List<Integer> keys = Arrays.asList(k);
		
		keys.forEach(x -> {
			String state = this.states.getOrDefault(x, "Anonymus State");
			System.out.println("State with key "+x+"="+state);
		});
		
		System.out.println();
	}
	
	private void useCollect(String filter) {
		System.out.println("Method useCollect:");
		System.out.println("States with substring '"+filter+"':");
		Map<Integer, String> result = this.states.entrySet().stream()
				.filter(e -> e.getValue().contains(filter))
				.collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
		result.entrySet().stream().forEach(System.out::println);
		System.out.println();
	}
	
	public static void main(String[] args) {
		MapApp app = new MapApp();
		app.fillStates();
		app.showStates(7);
		app.showStates(8);
		app.usePutIfAbasent();
		app.useComputeIfPresent();
		app.useGetOrDefault();
		app.useCollect("o");
	}
}
