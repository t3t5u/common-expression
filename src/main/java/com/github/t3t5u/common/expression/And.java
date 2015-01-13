package com.github.t3t5u.common.expression;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.BooleanUtils;

import com.github.t3t5u.common.util.CollectionUtils;
import com.github.t3t5u.common.util.ExtraObjectUtils;
import com.google.common.base.Function;
import com.google.common.base.Functions;

@SuppressWarnings("serial")
public class And extends AbstractBinaryExpression<Boolean, Boolean, Boolean> implements LogicalExpression {
	private static final And EMPTY = new And(new NullLiteral<Boolean>(), new NullLiteral<Boolean>());

	And(final Expression<Boolean> leftExpression, final Expression<Boolean> rightExpression) {
		super(Boolean.class, leftExpression, rightExpression);
	}

	@Override
	public Boolean evaluate() {
		final Boolean left = getLeftExpression().evaluate();
		final Boolean right = getRightExpression().evaluate();
		return (left != null) && (right != null) ? BooleanUtils.and(new Boolean[] { left, right }) : ExtraObjectUtils.<Boolean> asNull();
	}

	@Override
	public <R> R accept(final Visitor<R> visitor) {
		return visitor.visit(this);
	}

	@SafeVarargs
	public static And and(final Expression<Boolean>... expressions) {
		return and(expressions, Functions.<Expression<Boolean>> identity());
	}

	public static <T> And and(final T[] array, final Function<T, Expression<Boolean>> function) {
		// TODO: need optimize expression tree by boolean algebra.
		return ArrayUtils.isEmpty(array) ? EMPTY : array.length == 1 ? one(array, function) : array.length == 2 ? two(array, function) : CollectionUtils.foldLeft(ArrayUtils.subarray(array, 2, array.length), new Function<And, Function<Integer, And>>() {
			@Override
			public Function<Integer, And> apply(final And input) {
				return and(function, array, input);
			}
		}, two(array, function));
	}

	private static <T> And one(final T[] array, final Function<T, Expression<Boolean>> function) {
		return new And(BooleanLiteral.TRUE, function.apply(array[0]));
	}

	private static <T> And two(final T[] array, final Function<T, Expression<Boolean>> function) {
		return new And(function.apply(array[0]), function.apply(array[1]));
	}

	private static <T> Function<Integer, And> and(final Function<T, Expression<Boolean>> function, final T[] array, final And leftExpression) {
		return new Function<Integer, And>() {
			@Override
			public And apply(final Integer input) {
				return and(leftExpression, function, array, input);
			}
		};
	}

	private static <T> And and(final And leftExpression, final Function<T, Expression<Boolean>> function, final T[] array, final int index) {
		return new And(leftExpression, function.apply(array[index + 2]));
	}

	public static Expression<Boolean> andIfNotNull(final Expression<Boolean> leftExpression, final Expression<Boolean> rightExpression) {
		return leftExpression == null ? rightExpression : rightExpression == null ? leftExpression : new And(leftExpression, rightExpression);
	}
}
