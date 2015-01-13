package com.github.t3t5u.common.expression;

import java.text.NumberFormat;

@SuppressWarnings("serial")
public class IntegerLiteral extends NumberLiteral<Integer> {
	IntegerLiteral(final Integer value, final NumberFormat format) {
		super(Integer.class, value, format);
	}
}
