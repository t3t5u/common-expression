package com.github.t3t5u.common.expression;

public final class Unaries {
	private Unaries() {
	}

	public static Not not(final Expression<Boolean> expression) {
		return new Not(expression);
	}

	public static <T extends Number> Negate<T> negate(final Expression<T> expression) {
		return new Negate<T>(expression);
	}
}
