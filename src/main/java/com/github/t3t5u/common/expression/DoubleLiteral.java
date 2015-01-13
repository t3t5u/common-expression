package com.github.t3t5u.common.expression;

import java.text.NumberFormat;

@SuppressWarnings("serial")
public class DoubleLiteral extends NumberLiteral<Double> {
	DoubleLiteral(final Double value, final NumberFormat format) {
		super(Double.class, value, format);
	}
}
