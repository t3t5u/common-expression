package com.github.t3t5u.common.expression;

import java.io.Serializable;

public interface Expression<T extends Serializable> extends Serializable {
	T evaluate();

	Class<T> getExpressionClass();

	<R> R accept(Visitor<R> visitor);
}
