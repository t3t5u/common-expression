package com.github.t3t5u.common.expression;

import java.text.NumberFormat;

@SuppressWarnings("serial")
public class NumberLiteral<T extends Number> extends AbstractLiteralExpression<T> {
	private final NumberFormat format;

	NumberLiteral(final Class<T> expressionClass, final T value, final NumberFormat format) {
		super(expressionClass, value);
		this.format = format;
	}

	@Override
	public <R> R accept(final Visitor<R> visitor) {
		return visitor.visit(this);
	}

	public NumberFormat getFormat() {
		return format;
	}
}
