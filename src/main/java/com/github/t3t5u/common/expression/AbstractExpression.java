package com.github.t3t5u.common.expression;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

@SuppressWarnings("serial")
public abstract class AbstractExpression<T extends Serializable> implements Expression<T> {
	private final Class<T> expressionClass;

	protected AbstractExpression(final Class<T> expressionClass) {
		this.expressionClass = expressionClass;
	}

	@Override
	public Class<T> getExpressionClass() {
		return expressionClass;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
