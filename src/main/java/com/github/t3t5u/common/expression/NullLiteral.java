package com.github.t3t5u.common.expression;

import java.io.Serializable;

@SuppressWarnings("serial")
public class NullLiteral<T extends Serializable> extends AbstractLiteralExpression<T> {
	NullLiteral() {
		super(null, null);
	}

	@Override
	public <R> R accept(final Visitor<R> visitor) {
		return visitor.visit(this);
	}
}
