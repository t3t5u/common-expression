package com.github.t3t5u.common.expression;

import java.text.NumberFormat;

@SuppressWarnings("serial")
public class ByteLiteral extends NumberLiteral<Byte> {
	ByteLiteral(final Byte value, final NumberFormat format) {
		super(Byte.class, value, format);
	}
}
