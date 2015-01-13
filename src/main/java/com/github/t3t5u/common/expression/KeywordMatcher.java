package com.github.t3t5u.common.expression;

import java.io.Serializable;

@SuppressWarnings("serial")
public class KeywordMatcher<T extends CharSequence & Serializable> implements Matcher<T> {
	private final T keyword;
	private final MatchType matchType;

	KeywordMatcher(final T keyword, final MatchType matchType) {
		this.keyword = keyword;
		this.matchType = matchType;
	}

	public T getKeyword() {
		return keyword;
	}

	public MatchType getMatchType() {
		return matchType;
	}

	@Override
	public boolean match(final T sequence) {
		if ((sequence == null) && (keyword == null)) {
			return true;
		}
		if ((sequence == null) || (keyword == null)) {
			return false;
		}
		return match(sequence.toString(), keyword.toString(), matchType);
	}

	private static boolean match(final String sequence, final String keyword, final MatchType matchType) {
		return MatchType.FULL.equals(matchType) ? sequence.equals(keyword) : MatchType.FORWARD.equals(matchType) ? sequence.startsWith(keyword) : MatchType.BACKWARD.equals(matchType) ? sequence.endsWith(keyword) : sequence.contains(keyword);
	}
}
