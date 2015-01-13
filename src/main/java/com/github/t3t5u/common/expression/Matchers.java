package com.github.t3t5u.common.expression;

public final class Matchers {
	private Matchers() {
	}

	public static Pattern<String> pattern(final java.util.regex.Pattern pattern) {
		return new Pattern<String>(new PatternMatcher<String>(pattern));
	}

	public static Keyword<String> keyword(final String keyword, final MatchType matchType) {
		return new Keyword<String>(new KeywordMatcher<String>(keyword, matchType));
	}
}
