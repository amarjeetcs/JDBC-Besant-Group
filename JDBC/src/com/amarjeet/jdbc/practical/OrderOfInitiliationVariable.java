package com.amarjeet.jdbc.practical;

public class OrderOfInitiliationVariable {

	// Static variable
	private static String staticVar = initializeStaticVar();

	// Instance variable
	private String instanceVar = initializeInstanceVar();

	// Static block
	static {
		System.out.println("Static block executed.");
	}

	// Constructor
	public OrderOfInitiliationVariable() {
		System.out.println("Constructor executed.");
	}

	// Static method to initialize static variable
	private static String initializeStaticVar() {
		System.out.println("Static variable initialization.");
		return "Static Value";
	}

	// Instance method to initialize instance variable
	private String initializeInstanceVar() {
		System.out.println("Instance variable initialization.");
		return "Instance Value";
	}

	// Main method
	public static void main(String[] args) {
		System.out.println("Main method executed.");
		OrderOfInitiliationVariable obj = new OrderOfInitiliationVariable();
		System.out.println("Instance variable value: " + obj.instanceVar);
		System.out.println("Static variable value: " + staticVar);
	}
}
