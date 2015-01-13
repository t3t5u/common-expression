package com.github.t3t5u.common.expression;

import java.io.Serializable;

import javax.annotation.Nullable;

import com.google.common.base.Function;

public abstract class Inspector implements Visitor<Boolean> {
	public static final Function<Inspector, Function<BinaryExpression<?, ?, ?>, Boolean>> AND = and();
	public static final Function<Inspector, Function<BinaryExpression<?, ?, ?>, Boolean>> OR = or();
	private final boolean external;
	private final Function<Inspector, Function<BinaryExpression<?, ?, ?>, Boolean>> internal;

	public Inspector(final boolean external, final Function<Inspector, Function<BinaryExpression<?, ?, ?>, Boolean>> internal) {
		this.external = external;
		this.internal = internal;
	}

	protected boolean getExternal() {
		return external;
	}

	protected Function<Inspector, Function<BinaryExpression<?, ?, ?>, Boolean>> getInternal() {
		return internal;
	}

	@Override
	public final <T extends Serializable> Boolean visit(final NullLiteral<T> expression) {
		return inspect(expression);
	}

	@Override
	public final Boolean visit(final BooleanLiteral expression) {
		return inspect(expression);
	}

	@Override
	public final <T extends Number> Boolean visit(final NumberLiteral<T> expression) {
		return inspect(expression);
	}

	@Override
	public final Boolean visit(final CharacterLiteral expression) {
		return inspect(expression);
	}

	@Override
	public final <T extends CharSequence & Serializable> Boolean visit(final CharSequenceLiteral<T> expression) {
		return inspect(expression);
	}

	@Override
	public final <T extends Enum<T>> Boolean visit(final EnumLiteral<T> expression) {
		return inspect(expression);
	}

	@Override
	public final Boolean visit(final DateLiteral expression) {
		return inspect(expression);
	}

	@Override
	public final Boolean visit(final Not expression) {
		return inspect(expression);
	}

	@Override
	public final <T extends Number> Boolean visit(final Negate<T> expression) {
		return inspect(expression);
	}

	@Override
	public final Boolean visit(final And expression) {
		return inspect(expression);
	}

	@Override
	public final Boolean visit(final Or expression) {
		return inspect(expression);
	}

	@Override
	public final <T extends Number> Boolean visit(final Add<T> expression) {
		return inspect(expression);
	}

	@Override
	public final <T extends Number> Boolean visit(final Subtract<T> expression) {
		return inspect(expression);
	}

	@Override
	public final <T extends Number> Boolean visit(final Divide<T> expression) {
		return inspect(expression);
	}

	@Override
	public final <T extends Number> Boolean visit(final Multiply<T> expression) {
		return inspect(expression);
	}

	@Override
	public final <T extends Comparable<T> & Serializable> Boolean visit(final LessThan<T> expression) {
		return inspect(expression);
	}

	@Override
	public final <T extends Comparable<T> & Serializable> Boolean visit(final LessThanOrEqual<T> expression) {
		return inspect(expression);
	}

	@Override
	public final <T extends Comparable<T> & Serializable> Boolean visit(final GreaterThan<T> expression) {
		return inspect(expression);
	}

	@Override
	public final <T extends Comparable<T> & Serializable> Boolean visit(final GreaterThanOrEqual<T> expression) {
		return inspect(expression);
	}

	@Override
	public final <T extends Serializable> Boolean visit(final Equal<T> expression) {
		return inspect(expression);
	}

	@Override
	public final <T extends Serializable> Boolean visit(final NotEqual<T> expression) {
		return inspect(expression);
	}

	@Override
	public final <T extends Serializable, M extends Matcher<T>> Boolean visit(final Match<T, M> expression) {
		return inspect(expression);
	}

	@Override
	public final <T extends Serializable, M extends Matcher<T>> Boolean visit(final NotMatch<T, M> expression) {
		return inspect(expression);
	}

	@Override
	public final <T extends CharSequence & Serializable> Boolean visit(final Pattern<T> expression) {
		return inspect(expression);
	}

	@Override
	public final <T extends CharSequence & Serializable> Boolean visit(final Keyword<T> expression) {
		return inspect(expression);
	}

	protected <T extends Serializable> boolean inspect(final NullLiteral<T> expression) {
		return getExternal();
	}

	protected boolean inspect(final BooleanLiteral expression) {
		return getExternal();
	}

	protected <T extends Number> boolean inspect(final NumberLiteral<T> expression) {
		return getExternal();
	}

	protected boolean inspect(final CharacterLiteral expression) {
		return getExternal();
	}

	protected <T extends CharSequence & Serializable> boolean inspect(final CharSequenceLiteral<T> expression) {
		return getExternal();
	}

	protected <T extends Enum<T>> boolean inspect(final EnumLiteral<T> expression) {
		return getExternal();
	}

	protected boolean inspect(final DateLiteral expression) {
		return getExternal();
	}

	protected boolean inspect(final Not expression) {
		return expression.getExpression().accept(this);
	}

	protected <T extends Number> boolean inspect(final Negate<T> expression) {
		return expression.getExpression().accept(this);
	}

	protected boolean inspect(final And expression) {
		return getInternal().apply(this).apply(expression);
	}

	protected boolean inspect(final Or expression) {
		return getInternal().apply(this).apply(expression);
	}

	protected <T extends Number> boolean inspect(final Add<T> expression) {
		return getInternal().apply(this).apply(expression);
	}

	protected <T extends Number> boolean inspect(final Subtract<T> expression) {
		return getInternal().apply(this).apply(expression);
	}

	protected <T extends Number> boolean inspect(final Divide<T> expression) {
		return getInternal().apply(this).apply(expression);
	}

	protected <T extends Number> boolean inspect(final Multiply<T> expression) {
		return getInternal().apply(this).apply(expression);
	}

	protected <T extends Comparable<T> & Serializable> boolean inspect(final LessThan<T> expression) {
		return getInternal().apply(this).apply(expression);
	}

	protected <T extends Comparable<T> & Serializable> boolean inspect(final LessThanOrEqual<T> expression) {
		return getInternal().apply(this).apply(expression);
	}

	protected <T extends Comparable<T> & Serializable> boolean inspect(final GreaterThan<T> expression) {
		return getInternal().apply(this).apply(expression);
	}

	protected <T extends Comparable<T> & Serializable> boolean inspect(final GreaterThanOrEqual<T> expression) {
		return getInternal().apply(this).apply(expression);
	}

	protected <T extends Serializable> boolean inspect(final Equal<T> expression) {
		return getInternal().apply(this).apply(expression);
	}

	protected <T extends Serializable> boolean inspect(final NotEqual<T> expression) {
		return getInternal().apply(this).apply(expression);
	}

	protected <T extends Serializable, M extends Matcher<T>> boolean inspect(final Match<T, M> expression) {
		return getInternal().apply(this).apply(expression);
	}

	protected <T extends Serializable, M extends Matcher<T>> boolean inspect(final NotMatch<T, M> expression) {
		return getInternal().apply(this).apply(expression);
	}

	protected <T extends CharSequence & Serializable> boolean inspect(final Pattern<T> expression) {
		return getExternal();
	}

	protected <T extends CharSequence & Serializable> boolean inspect(final Keyword<T> expression) {
		return getExternal();
	}

	private static Function<Inspector, Function<BinaryExpression<?, ?, ?>, Boolean>> and() {
		return new Function<Inspector, Function<BinaryExpression<?, ?, ?>, Boolean>>() {
			@Override
			@Nullable
			public Function<BinaryExpression<?, ?, ?>, Boolean> apply(@Nullable final Inspector input) {
				return and(input);
			}
		};
	}

	private static Function<Inspector, Function<BinaryExpression<?, ?, ?>, Boolean>> or() {
		return new Function<Inspector, Function<BinaryExpression<?, ?, ?>, Boolean>>() {
			@Override
			@Nullable
			public Function<BinaryExpression<?, ?, ?>, Boolean> apply(@Nullable final Inspector input) {
				return or(input);
			}
		};
	}

	private static Function<BinaryExpression<?, ?, ?>, Boolean> and(final Inspector inspector) {
		return new Function<BinaryExpression<?, ?, ?>, Boolean>() {
			@Override
			public Boolean apply(final BinaryExpression<?, ?, ?> input) {
				return and(inspector, input);
			}
		};
	}

	private static Function<BinaryExpression<?, ?, ?>, Boolean> or(final Inspector inspector) {
		return new Function<BinaryExpression<?, ?, ?>, Boolean>() {
			@Override
			public Boolean apply(final BinaryExpression<?, ?, ?> input) {
				return or(inspector, input);
			}
		};
	}

	private static boolean and(final Inspector inspector, final BinaryExpression<?, ?, ?> expression) {
		return expression.getLeftExpression().accept(inspector) && expression.getRightExpression().accept(inspector);
	}

	private static boolean or(final Inspector inspector, final BinaryExpression<?, ?, ?> expression) {
		return expression.getLeftExpression().accept(inspector) || expression.getRightExpression().accept(inspector);
	}
}
