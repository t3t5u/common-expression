package com.github.t3t5u.common.expression;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CharSequenceLiteral<T extends CharSequence & Serializable> extends AbstractLiteralExpression<T> {
	CharSequenceLiteral(final Class<T> expressionClass, final T value) {
		super(expressionClass, value);
	}

	@Override
	public <R> R accept(final Visitor<R> visitor) {
		return visitor.visit(this);
	}
}
