package com.github.t3t5u.common.expression;

import java.io.Serializable;

import com.google.common.base.Objects;

@SuppressWarnings("serial")
public class Equal<T extends Serializable> extends AbstractBinaryExpression<T, T, Boolean> implements EqualityExpression<T> {
	Equal(final Expression<T> leftExpression, final Expression<T> rightExpression) {
		super(Boolean.class, leftExpression, rightExpression);
	}

	@Override
	public Boolean evaluate() {
		return Objects.equal(getLeftExpression().evaluate(), getRightExpression().evaluate());
	}

	@Override
	public <R> R accept(final Visitor<R> visitor) {
		return visitor.visit(this);
	}
}
