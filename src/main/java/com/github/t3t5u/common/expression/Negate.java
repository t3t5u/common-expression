package com.github.t3t5u.common.expression;

import com.github.t3t5u.common.util.ExtraNumberUtils;

@SuppressWarnings("serial")
public class Negate<T extends Number> extends AbstractUnaryExpression<T, T> implements ArithmeticExpression<T> {
	Negate(final Expression<T> expression) {
		super(expression != null ? expression.getExpressionClass() : null, expression);
	}

	@Override
	public T evaluate() {
		final T number = getExpression().evaluate();
		return number != null ? ExtraNumberUtils.toNumber(ExtraNumberUtils.toBigDecimal(number).negate(), getExpressionClass()) : null;
	}

	@Override
	public <R> R accept(final Visitor<R> visitor) {
		return visitor.visit(this);
	}
}
