package com.github.t3t5u.common.expression;

import java.io.Serializable;

public interface MatchingExpression<T extends Serializable, M extends Matcher<T>> extends BinaryExpression<T, M, Boolean> {
}
