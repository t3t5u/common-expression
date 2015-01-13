package com.github.t3t5u.common.expression;

import java.io.Serializable;

import org.apache.commons.lang3.ObjectUtils;

import com.google.common.base.Objects;

@SuppressWarnings("serial")
public class GreaterThanOrEqual<T extends Comparable<T> & Serializable> extends AbstractBinaryExpression<T, T, Boolean> implements ComparisonExpression<T> {
	GreaterThanOrEqual(final Expression<T> leftExpression, final Expression<T> rightExpression) {
		super(Boolean.class, leftExpression, rightExpression);
	}

	@Override
	public Boolean evaluate() {
		final T left = getLeftExpression().evaluate();
		final T right = getRightExpression().evaluate();
		return (ObjectUtils.compare(left, right) >= 0) || Objects.equal(left, right);
	}

	@Override
	public <R> R accept(final Visitor<R> visitor) {
		return visitor.visit(this);
	}
}
