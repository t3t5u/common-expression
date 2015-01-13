package com.github.t3t5u.common.expression;

import java.text.NumberFormat;

@SuppressWarnings("serial")
public class FloatLiteral extends NumberLiteral<Float> {
	FloatLiteral(final Float value, final NumberFormat format) {
		super(Float.class, value, format);
	}
}
