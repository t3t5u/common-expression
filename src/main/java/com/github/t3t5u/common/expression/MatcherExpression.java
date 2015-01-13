package com.github.t3t5u.common.expression;

import java.io.Serializable;

public interface MatcherExpression<T extends Serializable, M extends Matcher<T>> extends Expression<M> {
}
