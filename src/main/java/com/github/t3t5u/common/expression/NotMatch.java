package com.github.t3t5u.common.expression;

import java.io.Serializable;

import com.github.t3t5u.common.util.ExtraObjectUtils;

@SuppressWarnings("serial")
public class NotMatch<T extends Serializable, M extends Matcher<T>> extends AbstractBinaryExpression<T, M, Boolean> implements MatchingExpression<T, M> {
	NotMatch(final Expression<T> leftExpression, final MatcherExpression<T, M> rightExpression) {
		super(Boolean.class, leftExpression, rightExpression);
	}

	@Override
	public Boolean evaluate() {
		final M matcher = getRightExpression().evaluate();
		return matcher != null ? !matcher.match(getLeftExpression().evaluate()) : ExtraObjectUtils.<Boolean> asNull();
	}

	@Override
	public <R> R accept(final Visitor<R> visitor) {
		return visitor.visit(this);
	}
}
