package com.github.t3t5u.common.expression;

import java.text.DateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class DateLiteral extends AbstractLiteralExpression<Date> {
	private final DateFormat format;

	DateLiteral(final Date value, final DateFormat format) {
		super(Date.class, value);
		this.format = format;
	}

	@Override
	public <R> R accept(final Visitor<R> visitor) {
		return visitor.visit(this);
	}

	public DateFormat getFormat() {
		return format;
	}
}
