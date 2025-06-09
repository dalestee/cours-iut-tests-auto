package com.sqli.isc.iut.courses.cucumber;

import static java.util.Arrays.asList;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Calculator {

	private static final List<String> OPERANDS = asList("-", "+", "*", "/");

	private final Deque<Number> stack = new LinkedList<>();

	public void push(Object arg) {
		if (OPERANDS.contains(arg)) {
			Number y = stack.removeLast();
			Number x = stack.isEmpty() ? 0 : stack.removeLast();
			Double val = null;

			if (arg.equals("-")) {
				val = x.doubleValue() - y.doubleValue();
			} else if (arg.equals("+")) {
				val = x.doubleValue() + y.doubleValue();
			} else if (arg.equals("*")) {
				val = x.doubleValue() * y.doubleValue();
			} else if (arg.equals("/")) {
				val = x.doubleValue() / y.doubleValue();
			}

			push(val);
		} else {
			stack.add((Number) arg);
		}
	}

	public Number value() {
		return stack.getLast();
	}

	// Method to subtract two integers
	public int substract(int i, int i2) {
		return i - i2;
	}

	// Method to add two integers
	public int add(int i, int i2) {
		return i + i2;
	}

	// Method to return the current result (value from the stack)
	public int getResult() {
		if (stack.isEmpty()) {
			throw new IllegalStateException("No result available in the stack.");
		}
		return stack.getLast().intValue();
	}
}
