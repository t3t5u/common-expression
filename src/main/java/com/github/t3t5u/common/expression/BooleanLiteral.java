package com.github.t3t5u.common.expression;

@SuppressWarnings("serial")
public class BooleanLiteral extends AbstractLiteralExpression<Boolean> {
	public static final BooleanLiteral TRUE = new BooleanLiteral(true);
	public static final BooleanLiteral FALSE = new BooleanLiteral(false);

	BooleanLiteral(final Boolean value) {
		super(Boolean.class, value);
	}

	@Override
	public <R> R accept(final Visitor<R> visitor) {
		return visitor.visit(this);
	}
}
