package com.github.t3t5u.common.expression;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;

public final class Literals {
	private Literals() {
	}

	public static <T extends Serializable> NullLiteral<T> asNull() {
		return new NullLiteral<T>();
	}

	public static BooleanLiteral asBoolean(final Boolean value) {
		return new BooleanLiteral(value);
	}

	public static BigDecimalLiteral asBigDecimal(final BigDecimal value) {
		return asBigDecimal(value, null);
	}

	public static BigDecimalLiteral asBigDecimal(final BigDecimal value, final NumberFormat format) {
		return new BigDecimalLiteral(value, format);
	}

	public static ByteLiteral asByte(final Byte value) {
		return asByte(value, null);
	}

	public static ByteLiteral asByte(final Byte value, final NumberFormat format) {
		return new ByteLiteral(value, format);
	}

	public static ShortLiteral asShort(final Short value) {
		return asShort(value, null);
	}

	public static ShortLiteral asShort(final Short value, final NumberFormat format) {
		return new ShortLiteral(value, format);
	}

	public static IntegerLiteral asInteger(final Integer value) {
		return asInteger(value, null);
	}

	public static IntegerLiteral asInteger(final Integer value, final NumberFormat format) {
		return new IntegerLiteral(value, format);
	}

	public static LongLiteral asLong(final Long value) {
		return asLong(value, null);
	}

	public static LongLiteral asLong(final Long value, final NumberFormat format) {
		return new LongLiteral(value, format);
	}

	public static FloatLiteral asFloat(final Float value) {
		return asFloat(value, null);
	}

	public static FloatLiteral asFloat(final Float value, final NumberFormat format) {
		return new FloatLiteral(value, format);
	}

	public static DoubleLiteral asDouble(final Double value) {
		return asDouble(value, null);
	}

	public static DoubleLiteral asDouble(final Double value, final NumberFormat format) {
		return new DoubleLiteral(value, format);
	}

	public static CharacterLiteral asCharacter(final Character value) {
		return new CharacterLiteral(value);
	}

	public static StringLiteral asString(final String value) {
		return new StringLiteral(value);
	}

	public static <T extends Enum<T>> EnumLiteral<T> asEnum(final T value) {
		return new EnumLiteral<T>(value);
	}

	public static DateLiteral asDate(final Date value) {
		return asDate(value, null);
	}

	public static DateLiteral asDate(final Date value, final DateFormat format) {
		return new DateLiteral(value, format);
	}
}
