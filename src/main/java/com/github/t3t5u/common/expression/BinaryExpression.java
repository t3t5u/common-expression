package com.github.t3t5u.common.expression;

import java.io.Serializable;

public interface BinaryExpression<L extends Serializable, R extends Serializable, T extends Serializable> extends Expression<T> {
	Expression<L> getLeftExpression();

	Expression<R> getRightExpression();
}
