package com.github.t3t5u.common.expression;

import java.io.Serializable;

public final class Binaries {
	private Binaries() {
	}

	public static And and(final Expression<Boolean> leftExpression, final Expression<Boolean> rightExpression) {
		return new And(leftExpression, rightExpression);
	}

	public static Or or(final Expression<Boolean> leftExpression, final Expression<Boolean> rightExpression) {
		return new Or(leftExpression, rightExpression);
	}

	public static <T extends Number> Add<T> add(final Expression<T> leftExpression, final Expression<T> rightExpression) {
		return new Add<T>(leftExpression, rightExpression);
	}

	public static <T extends Number> Subtract<T> subtract(final Expression<T> leftExpression, final Expression<T> rightExpression) {
		return new Subtract<T>(leftExpression, rightExpression);
	}

	public static <T extends Number> Divide<T> divide(final Expression<T> leftExpression, final Expression<T> rightExpression) {
		return new Divide<T>(leftExpression, rightExpression);
	}

	public static <T extends Number> Multiply<T> multiply(final Expression<T> leftExpression, final Expression<T> rightExpression) {
		return new Multiply<T>(leftExpression, rightExpression);
	}

	public static <T extends Comparable<T> & Serializable> LessThan<T> lessThan(final Expression<T> leftExpression, final Expression<T> rightExpression) {
		return new LessThan<T>(leftExpression, rightExpression);
	}

	public static <T extends Comparable<T> & Serializable> LessThanOrEqual<T> lessThanOrEqual(final Expression<T> leftExpression, final Expression<T> rightExpression) {
		return new LessThanOrEqual<T>(leftExpression, rightExpression);
	}

	public static <T extends Comparable<T> & Serializable> GreaterThan<T> greaterThan(final Expression<T> leftExpression, final Expression<T> rightExpression) {
		return new GreaterThan<T>(leftExpression, rightExpression);
	}

	public static <T extends Comparable<T> & Serializable> GreaterThanOrEqual<T> greaterThanOrEqual(final Expression<T> leftExpression, final Expression<T> rightExpression) {
		return new GreaterThanOrEqual<T>(leftExpression, rightExpression);
	}

	public static <T extends Serializable> Equal<T> equal(final Expression<T> leftExpression, final Expression<T> rightExpression) {
		return new Equal<T>(leftExpression, rightExpression);
	}

	public static <T extends Serializable> NotEqual<T> notEqual(final Expression<T> leftExpression, final Expression<T> rightExpression) {
		return new NotEqual<T>(leftExpression, rightExpression);
	}

	public static <T extends Serializable, M extends Matcher<T>> Match<T, M> match(final Expression<T> leftExpression, final MatcherExpression<T, M> rightExpression) {
		return new Match<T, M>(leftExpression, rightExpression);
	}

	public static <T extends Serializable, M extends Matcher<T>> NotMatch<T, M> notMatch(final Expression<T> leftExpression, final MatcherExpression<T, M> rightExpression) {
		return new NotMatch<T, M>(leftExpression, rightExpression);
	}
}
