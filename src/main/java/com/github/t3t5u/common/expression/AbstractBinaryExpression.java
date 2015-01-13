package com.github.t3t5u.common.expression;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class AbstractBinaryExpression<L extends Serializable, R extends Serializable, T extends Serializable> extends AbstractExpression<T> implements BinaryExpression<L, R, T> {
	private final Expression<L> leftExpression;
	private final Expression<R> rightExpression;

	protected AbstractBinaryExpression(final Class<T> expressionClass, final Expression<L> leftExpression, final Expression<R> rightExpression) {
		super(expressionClass);
		this.leftExpression = leftExpression != null ? leftExpression : new NullLiteral<L>();
		this.rightExpression = rightExpression != null ? rightExpression : new NullLiteral<R>();
	}

	@Override
	public Expression<L> getLeftExpression() {
		return leftExpression;
	}

	@Override
	public Expression<R> getRightExpression() {
		return rightExpression;
	}
}
