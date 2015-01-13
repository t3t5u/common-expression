package com.github.t3t5u.common.expression;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class AbstractMatcherExpression<T extends Serializable, M extends Matcher<T>> extends AbstractExpression<M> implements MatcherExpression<T, M> {
	private final M matcher;

	@SuppressWarnings("unchecked")
	protected AbstractMatcherExpression(final M matcher) {
		super(matcher != null ? (Class<M>) matcher.getClass() : null);
		this.matcher = matcher;
	}

	@Override
	public M evaluate() {
		return matcher;
	}
}
