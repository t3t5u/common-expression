package com.github.t3t5u.common.expression;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class AbstractLiteralExpression<T extends Serializable> extends AbstractExpression<T> implements LiteralExpression<T> {
	private final T value;

	protected AbstractLiteralExpression(final Class<T> expressionClass, final T value) {
		super(expressionClass);
		this.value = value;
	}

	@Override
	public T evaluate() {
		return value;
	}
}
