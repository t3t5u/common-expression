package com.github.t3t5u.common.expression;

import java.io.Serializable;

import org.apache.commons.lang3.ObjectUtils;

@SuppressWarnings("serial")
public class GreaterThan<T extends Comparable<T> & Serializable> extends AbstractBinaryExpression<T, T, Boolean> implements ComparisonExpression<T> {
	GreaterThan(final Expression<T> leftExpression, final Expression<T> rightExpression) {
		super(Boolean.class, leftExpression, rightExpression);
	}

	@Override
	public Boolean evaluate() {
		return ObjectUtils.compare(getLeftExpression().evaluate(), getRightExpression().evaluate()) > 0;
	}

	@Override
	public <R> R accept(final Visitor<R> visitor) {
		return visitor.visit(this);
	}
}
