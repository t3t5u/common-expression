package com.github.t3t5u.common.expression;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Keyword<T extends CharSequence & Serializable> extends AbstractMatcherExpression<T, KeywordMatcher<T>> {
	Keyword(final KeywordMatcher<T> matcher) {
		super(matcher);
	}

	@Override
	public <R> R accept(final Visitor<R> visitor) {
		return visitor.visit(this);
	}
}
