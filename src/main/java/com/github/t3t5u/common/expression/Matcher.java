package com.github.t3t5u.common.expression;

import java.io.Serializable;

public interface Matcher<T extends Serializable> extends Serializable {
	boolean match(T sequence);
}
