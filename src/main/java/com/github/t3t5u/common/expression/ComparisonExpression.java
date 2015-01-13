package com.github.t3t5u.common.expression;

import java.io.Serializable;

public interface ComparisonExpression<T extends Comparable<T> & Serializable> extends RelationalExpression<T> {
}
