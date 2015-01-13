package com.github.t3t5u.common.expression;

import java.io.Serializable;
import java.util.regex.Pattern;

@SuppressWarnings("serial")
public class PatternMatcher<T extends CharSequence & Serializable> implements Matcher<T> {
	private final Pattern pattern;

	PatternMatcher(final Pattern pattern) {
		this.pattern = pattern;
	}

	public Pattern getPattern() {
		return pattern;
	}

	@Override
	public boolean match(final T sequence) {
		return (pattern != null) && (sequence != null) && pattern.matcher(sequence).matches();
	}
}
