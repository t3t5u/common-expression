package com.github.t3t5u.common.expression;

import java.text.NumberFormat;

@SuppressWarnings("serial")
public class LongLiteral extends NumberLiteral<Long> {
	LongLiteral(final Long value, final NumberFormat format) {
		super(Long.class, value, format);
	}
}
