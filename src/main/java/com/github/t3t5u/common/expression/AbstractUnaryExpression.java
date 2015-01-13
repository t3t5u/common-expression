package com.github.t3t5u.common.expression;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class AbstractUnaryExpression<F extends Serializable, T extends Serializable> extends AbstractExpression<T> implements UnaryExpression<F, T> {
	private final Expression<F> expression;

	protected AbstractUnaryExpression(final Class<T> expressionClass, final Expression<F> expression) {
		super(expressionClass);
		this.expression = expression != null ? expression : new NullLiteral<F>();
	}

	@Override
	public Expression<F> getExpression() {
		return expression;
	}
}
