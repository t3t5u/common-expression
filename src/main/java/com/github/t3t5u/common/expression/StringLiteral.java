package com.github.t3t5u.common.expression;

@SuppressWarnings("serial")
public class StringLiteral extends CharSequenceLiteral<String> {
	StringLiteral(final String value) {
		super(String.class, value);
	}
}
