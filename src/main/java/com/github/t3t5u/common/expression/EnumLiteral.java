package com.github.t3t5u.common.expression;

@SuppressWarnings("serial")
public class EnumLiteral<T extends Enum<T>> extends AbstractLiteralExpression<T> {
	@SuppressWarnings("unchecked")
	EnumLiteral(final T value) {
		super(value != null ? (Class<T>) value.getClass() : null, value);
	}

	@Override
	public <R> R accept(final Visitor<R> visitor) {
		return visitor.visit(this);
	}
}
