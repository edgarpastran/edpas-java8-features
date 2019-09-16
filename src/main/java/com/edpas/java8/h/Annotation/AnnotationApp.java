package com.edpas.java8.h.Annotation;

public class AnnotationApp {

	private void showAnnotationsWithJDK8() {
		State[] statesArray = GeographicalStateWithJDK7.class.getAnnotationsByType(State.class);
		System.out.println("States count: "+statesArray.length);
		
		States states = GeographicalStateWithJDK7.class.getAnnotation(States.class);
		for (State state: states.value()) {
			System.out.println(state.value());
		}
	}

	private void showAnnotationsWithJDK7() {
		State[] statesArray = GeographicalStateWithJDK7.class.getAnnotationsByType(State.class);
		System.out.println("States count: "+statesArray.length);
		
		States states = GeographicalStateWithJDK7.class.getAnnotation(States.class);
		for (State state: states.value()) {
			System.out.println(state.value());
		}
	}
	
	private void showAnnotations(int version) {
		if (version <= 7) {
			System.out.println("JDK <= 7");
			this.showAnnotationsWithJDK7();
		}
		else {
			System.out.println("JDK = 8");
			this.showAnnotationsWithJDK8();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		AnnotationApp app = new AnnotationApp();
		app.showAnnotations(7);
		app.showAnnotations(8);
	}
}
