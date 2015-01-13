package com.github.t3t5u.common.expression;

import java.text.NumberFormat;

@SuppressWarnings("serial")
public class ShortLiteral extends NumberLiteral<Short> {
	ShortLiteral(final Short value, final NumberFormat format) {
		super(Short.class, value, format);
	}
}
