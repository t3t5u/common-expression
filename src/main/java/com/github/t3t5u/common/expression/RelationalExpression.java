package com.github.t3t5u.common.expression;

import java.io.Serializable;

public interface RelationalExpression<T extends Serializable> extends BinaryExpression<T, T, Boolean> {
}
