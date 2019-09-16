package com.edpas.java8.a.lambda;

public class LambdaExpression2 {

	private void getAverageWithJava7() {
		System.out.println("JDK <= 7:");
		IAuxiliar average = new IAuxiliar() {			
			@Override
			public double calculate(double n1, double n2) {
				return (n1 + n2) / 2;
			}
		};

		System.out.println(average.calculate(2, 3));
		
		System.out.println();
	}
	
	private void getAverageWithJava8() {
		System.out.println("Lambda Expresion:");
		IAuxiliar average = (double x, double y) -> (x+y)/2;
		System.out.println(average.calculate(2, 3));
		
		System.out.println();
	}
	
	public void getAverage(int version) {
		if (version <= 7) {
			this.getAverageWithJava7();
		}
		else {
			this.getAverageWithJava8();
		}		
	}
	
	public static void main(String[] args) {
		LambdaExpression2 lambda = new LambdaExpression2();
		lambda.getAverage(7);
		lambda.getAverage(8);
	}
}
