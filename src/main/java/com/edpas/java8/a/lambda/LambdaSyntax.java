package com.edpas.java8.a.lambda;

public class LambdaSyntax {

	private double syntax1() {
		System.out.println("Method syntax1:");
		IAuxiliar average = (double x, double y) -> (x + y) / 2;
		return average.calculate(2,3);
	}
	
	private double syntax2() {
		System.out.println("Method syntax2:");
		IAuxiliar average = (x, y) -> (x + y) / 2;
		return average.calculate(2,3);
	}
	
	private double syntax3() {
		System.out.println("Method syntax3:");
		IAuxiliar average = (double x, double y) -> {
			return (x + y) / 2;
		};
		return average.calculate(2,3);
	}
	
	private double syntax4() {
		System.out.println("Method syntax4:");
		IAuxiliar average = (x, y) -> {
			return (x + y) / 2;
		};
		return average.calculate(2,3);
	}
	
	public static void main(String[] args) {
		LambdaSyntax lambda = new LambdaSyntax();
		System.out.println(lambda.syntax1());
		System.out.println();
		System.out.println(lambda.syntax2());
		System.out.println();
		System.out.println(lambda.syntax3());
		System.out.println();
		System.out.println(lambda.syntax4());
	}
}
