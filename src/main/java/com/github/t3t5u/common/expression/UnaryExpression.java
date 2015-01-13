package com.github.t3t5u.common.expression;

import java.io.Serializable;

public interface UnaryExpression<F extends Serializable, T extends Serializable> extends Expression<T> {
	Expression<F> getExpression();
}
