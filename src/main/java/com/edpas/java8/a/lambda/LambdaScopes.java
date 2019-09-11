package com.edpas.java8.a.lambda;

public class LambdaScopes {

	private static double attribute1;
	private double attribute2;	
	
	private double testLocalVariableWithJava7() {
		System.out.println("JDK <= 1.7:");
		final double n3 = 3;
		IAuxiliar add = new IAuxiliar(){
			@Override
			public double calculate(double n1, double n2) {				
				return n1 + n2 + n3;
			}
		};					
		return add.calculate(1,1);
	}
	
	private double testLocalVariableWithJava8() {
		System.out.println("Lambda Expression:");
		final double n3 = 3;
		IAuxiliar add = (x,y) -> {				
			return x + y + n3;
		};
		return add.calculate(1,1);
	}
	
	public void testLocalVariable(int version) {
		if (version <= 7) {
			System.out.println(this.testLocalVariableWithJava7());
			System.out.println();
		}
		else {
			System.out.println(this.testLocalVariableWithJava8());
			System.out.println();
		}
	}
	
	private double testAttributesWithJava7() {
		System.out.println("JDK <= 1.7:");
		IAuxiliar add = new IAuxiliar(){
			@Override
			public double calculate(double n1, double n2) {
				attribute1 = n1 + n2;
				attribute2 = attribute1;
				return attribute2;
			}
		};		
		return add.calculate(3, 2);
	}
	
	private double testAttributesWithJava8() {
		System.out.println("Lambda Expression:");
		IAuxiliar add = (n1, n2) -> {
			attribute1 = n1 + n2;
			attribute2 = attribute1;
			return attribute2;
		};
		return add.calculate(3, 2);
	}
	
	public void testAttributes(int version) {
		if (version <= 7) {
			System.out.println(this.testAttributesWithJava7());
			System.out.println();
		}
		else {
			System.out.println(this.testAttributesWithJava8());
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		LambdaScopes lambda = new LambdaScopes();
		lambda.testLocalVariable(7);
		lambda.testLocalVariable(8);
		lambda.testAttributes(7);
		lambda.testAttributes(8);
	}
}
