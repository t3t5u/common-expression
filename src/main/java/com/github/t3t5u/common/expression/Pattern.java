package com.github.t3t5u.common.expression;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Pattern<T extends CharSequence & Serializable> extends AbstractMatcherExpression<T, PatternMatcher<T>> {
	Pattern(final PatternMatcher<T> matcher) {
		super(matcher);
	}

	@Override
	public <R> R accept(final Visitor<R> visitor) {
		return visitor.visit(this);
	}
}
