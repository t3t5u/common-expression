package com.github.t3t5u.common.expression;

import java.io.Serializable;

import com.google.common.base.Function;

public interface Literalizer<F, T extends Serializable> extends Function<F, LiteralExpression<T>>, Serializable {
}
