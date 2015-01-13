package com.github.t3t5u.common.expression;

import com.github.t3t5u.common.util.ExtraNumberUtils;

@SuppressWarnings("serial")
public class Subtract<T extends Number> extends AbstractBinaryExpression<T, T, T> implements ArithmeticExpression<T> {
	Subtract(final Expression<T> leftExpression, final Expression<T> rightExpression) {
		super(leftExpression != null ? leftExpression.getExpressionClass() : rightExpression != null ? rightExpression.getExpressionClass() : null, leftExpression, rightExpression);
	}

	@Override
	public T evaluate() {
		final T left = getLeftExpression().evaluate();
		final T right = getRightExpression().evaluate();
		return (left != null) && (right != null) ? ExtraNumberUtils.toNumber(ExtraNumberUtils.toBigDecimal(left).subtract(ExtraNumberUtils.toBigDecimal(right)), getExpressionClass()) : null;
	}

	@Override
	public <R> R accept(final Visitor<R> visitor) {
		return visitor.visit(this);
	}
}
