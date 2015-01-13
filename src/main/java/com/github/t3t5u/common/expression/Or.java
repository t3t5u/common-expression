package com.github.t3t5u.common.expression;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.BooleanUtils;

import com.github.t3t5u.common.util.CollectionUtils;
import com.github.t3t5u.common.util.ExtraObjectUtils;
import com.google.common.base.Function;
import com.google.common.base.Functions;

@SuppressWarnings("serial")
public class Or extends AbstractBinaryExpression<Boolean, Boolean, Boolean> implements LogicalExpression {
	private static final Or EMPTY = new Or(new NullLiteral<Boolean>(), new NullLiteral<Boolean>());

	Or(final Expression<Boolean> leftExpression, final Expression<Boolean> rightExpression) {
		super(Boolean.class, leftExpression, rightExpression);
	}

	@Override
	public Boolean evaluate() {
		final Boolean left = getLeftExpression().evaluate();
		final Boolean right = getRightExpression().evaluate();
		return (left != null) && (right != null) ? BooleanUtils.or(new Boolean[] { left, right }) : ExtraObjectUtils.<Boolean> asNull();
	}

	@Override
	public <R> R accept(final Visitor<R> visitor) {
		return visitor.visit(this);
	}

	@SafeVarargs
	public static Or or(final Expression<Boolean>... expressions) {
		return or(expressions, Functions.<Expression<Boolean>> identity());
	}

	public static <T> Or or(final T[] array, final Function<T, Expression<Boolean>> function) {
		// TODO: need optimize expression tree by boolean algebra.
		return ArrayUtils.isEmpty(array) ? EMPTY : array.length == 1 ? one(array, function) : array.length == 2 ? two(array, function) : CollectionUtils.foldLeft(ArrayUtils.subarray(array, 2, array.length), new Function<Or, Function<Integer, Or>>() {
			@Override
			public Function<Integer, Or> apply(final Or input) {
				return or(function, array, input);
			}
		}, two(array, function));
	}

	private static <T> Or one(final T[] array, final Function<T, Expression<Boolean>> function) {
		return new Or(BooleanLiteral.FALSE, function.apply(array[0]));
	}

	private static <T> Or two(final T[] array, final Function<T, Expression<Boolean>> function) {
		return new Or(function.apply(array[0]), function.apply(array[1]));
	}

	private static <T> Function<Integer, Or> or(final Function<T, Expression<Boolean>> function, final T[] array, final Or leftExpression) {
		return new Function<Integer, Or>() {
			@Override
			public Or apply(final Integer input) {
				return or(leftExpression, function, array, input);
			}
		};
	}

	private static <T> Or or(final Or leftExpression, final Function<T, Expression<Boolean>> function, final T[] array, final int index) {
		return new Or(leftExpression, function.apply(array[index + 2]));
	}

	public static Expression<Boolean> orIfNotNull(final Expression<Boolean> leftExpression, final Expression<Boolean> rightExpression) {
		return leftExpression == null ? rightExpression : rightExpression == null ? leftExpression : new Or(leftExpression, rightExpression);
	}
}
