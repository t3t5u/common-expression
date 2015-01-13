package com.github.t3t5u.common.expression;

import java.math.BigDecimal;
import java.text.NumberFormat;

@SuppressWarnings("serial")
public class BigDecimalLiteral extends NumberLiteral<BigDecimal> {
	BigDecimalLiteral(final BigDecimal value, final NumberFormat format) {
		super(BigDecimal.class, value, format);
	}
}
