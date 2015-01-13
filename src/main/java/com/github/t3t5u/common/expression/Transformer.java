package com.github.t3t5u.common.expression;

import java.io.Serializable;
import java.util.Date;

public abstract class Transformer implements Visitor<Expression<? extends Serializable>> {
	@Override
	public final <T extends Serializable> Expression<? extends Serializable> visit(final NullLiteral<T> expression) {
		return transform(expression);
	}

	@Override
	public final Expression<? extends Serializable> visit(final BooleanLiteral expression) {
		return transform(expression);
	}

	@Override
	public final <T extends Number> Expression<? extends Serializable> visit(final NumberLiteral<T> expression) {
		return transform(expression);
	}

	@Override
	public final Expression<? extends Serializable> visit(final CharacterLiteral expression) {
		return transform(expression);
	}

	@Override
	public final <T extends CharSequence & Serializable> Expression<? extends Serializable> visit(final CharSequenceLiteral<T> expression) {
		return transform(expression);
	}

	@Override
	public final <T extends Enum<T>> Expression<? extends Serializable> visit(final EnumLiteral<T> expression) {
		return transform(expression);
	}

	@Override
	public final Expression<? extends Serializable> visit(final DateLiteral expression) {
		return transform(expression);
	}

	@Override
	public final Expression<? extends Serializable> visit(final Not expression) {
		return transform(expression);
	}

	@Override
	public final <T extends Number> Expression<? extends Serializable> visit(final Negate<T> expression) {
		return transform(expression);
	}

	@Override
	public final Expression<? extends Serializable> visit(final And expression) {
		return transform(expression);
	}

	@Override
	public final Expression<? extends Serializable> visit(final Or expression) {
		return transform(expression);
	}

	@Override
	public final <T extends Number> Expression<? extends Serializable> visit(final Add<T> expression) {
		return transform(expression);
	}

	@Override
	public final <T extends Number> Expression<? extends Serializable> visit(final Subtract<T> expression) {
		return transform(expression);
	}

	@Override
	public final <T extends Number> Expression<? extends Serializable> visit(final Divide<T> expression) {
		return transform(expression);
	}

	@Override
	public final <T extends Number> Expression<? extends Serializable> visit(final Multiply<T> expression) {
		return transform(expression);
	}

	@Override
	public final <T extends Comparable<T> & Serializable> Expression<? extends Serializable> visit(final LessThan<T> expression) {
		return transform(expression);
	}

	@Override
	public final <T extends Comparable<T> & Serializable> Expression<? extends Serializable> visit(final LessThanOrEqual<T> expression) {
		return transform(expression);
	}

	@Override
	public final <T extends Comparable<T> & Serializable> Expression<? extends Serializable> visit(final GreaterThan<T> expression) {
		return transform(expression);
	}

	@Override
	public final <T extends Comparable<T> & Serializable> Expression<? extends Serializable> visit(final GreaterThanOrEqual<T> expression) {
		return transform(expression);
	}

	@Override
	public final <T extends Serializable> Expression<? extends Serializable> visit(final Equal<T> expression) {
		return transform(expression);
	}

	@Override
	public final <T extends Serializable> Expression<? extends Serializable> visit(final NotEqual<T> expression) {
		return transform(expression);
	}

	@Override
	public final <T extends Serializable, M extends Matcher<T>> Expression<? extends Serializable> visit(final Match<T, M> expression) {
		return transform(expression);
	}

	@Override
	public final <T extends Serializable, M extends Matcher<T>> Expression<? extends Serializable> visit(final NotMatch<T, M> expression) {
		return transform(expression);
	}

	@Override
	public final <T extends CharSequence & Serializable> Expression<? extends Serializable> visit(final Pattern<T> expression) {
		return transform(expression);
	}

	@Override
	public final <T extends CharSequence & Serializable> Expression<? extends Serializable> visit(final Keyword<T> expression) {
		return transform(expression);
	}

	protected <T extends Serializable> Expression<T> transform(final NullLiteral<T> expression) {
		return expression;
	}

	protected Expression<Boolean> transform(final BooleanLiteral expression) {
		return expression;
	}

	protected <T extends Number> Expression<T> transform(final NumberLiteral<T> expression) {
		return expression;
	}

	protected Expression<Character> transform(final CharacterLiteral expression) {
		return expression;
	}

	protected <T extends CharSequence & Serializable> Expression<T> transform(final CharSequenceLiteral<T> expression) {
		return expression;
	}

	protected <T extends Enum<T>> Expression<T> transform(final EnumLiteral<T> expression) {
		return expression;
	}

	protected Expression<Date> transform(final DateLiteral expression) {
		return expression;
	}

	@SuppressWarnings("unchecked")
	protected Expression<Boolean> transform(final Not expression) {
		return Unaries.not((Expression<Boolean>) expression.getExpression().accept(this));
	}

	@SuppressWarnings("unchecked")
	protected <T extends Number> Expression<T> transform(final Negate<T> expression) {
		return Unaries.negate((Expression<T>) expression.getExpression().accept(this));
	}

	@SuppressWarnings("unchecked")
	protected Expression<Boolean> transform(final And expression) {
		return Binaries.and((Expression<Boolean>) expression.getLeftExpression().accept(this), (Expression<Boolean>) expression.getRightExpression().accept(this));
	}

	@SuppressWarnings("unchecked")
	protected Expression<Boolean> transform(final Or expression) {
		return Binaries.or((Expression<Boolean>) expression.getLeftExpression().accept(this), (Expression<Boolean>) expression.getRightExpression().accept(this));
	}

	@SuppressWarnings("unchecked")
	protected <T extends Number> Expression<T> transform(final Add<T> expression) {
		return Binaries.add((Expression<T>) expression.getLeftExpression().accept(this), (Expression<T>) expression.getRightExpression().accept(this));
	}

	@SuppressWarnings("unchecked")
	protected <T extends Number> Expression<T> transform(final Subtract<T> expression) {
		return Binaries.subtract((Expression<T>) expression.getLeftExpression().accept(this), (Expression<T>) expression.getRightExpression().accept(this));
	}

	@SuppressWarnings("unchecked")
	protected <T extends Number> Expression<T> transform(final Divide<T> expression) {
		return Binaries.divide((Expression<T>) expression.getLeftExpression().accept(this), (Expression<T>) expression.getRightExpression().accept(this));
	}

	@SuppressWarnings("unchecked")
	protected <T extends Number> Expression<T> transform(final Multiply<T> expression) {
		return Binaries.multiply((Expression<T>) expression.getLeftExpression().accept(this), (Expression<T>) expression.getRightExpression().accept(this));
	}

	@SuppressWarnings("unchecked")
	protected <T extends Comparable<T> & Serializable> Expression<Boolean> transform(final LessThan<T> expression) {
		return Binaries.lessThan((Expression<T>) expression.getLeftExpression().accept(this), (Expression<T>) expression.getRightExpression().accept(this));
	}

	@SuppressWarnings("unchecked")
	protected <T extends Comparable<T> & Serializable> Expression<Boolean> transform(final LessThanOrEqual<T> expression) {
		return Binaries.lessThanOrEqual((Expression<T>) expression.getLeftExpression().accept(this), (Expression<T>) expression.getRightExpression().accept(this));
	}

	@SuppressWarnings("unchecked")
	protected <T extends Comparable<T> & Serializable> Expression<Boolean> transform(final GreaterThan<T> expression) {
		return Binaries.greaterThan((Expression<T>) expression.getLeftExpression().accept(this), (Expression<T>) expression.getRightExpression().accept(this));
	}

	@SuppressWarnings("unchecked")
	protected <T extends Comparable<T> & Serializable> Expression<Boolean> transform(final GreaterThanOrEqual<T> expression) {
		return Binaries.greaterThanOrEqual((Expression<T>) expression.getLeftExpression().accept(this), (Expression<T>) expression.getRightExpression().accept(this));
	}

	@SuppressWarnings("unchecked")
	protected <T extends Serializable> Expression<Boolean> transform(final Equal<T> expression) {
		return Binaries.equal((Expression<T>) expression.getLeftExpression().accept(this), (Expression<T>) expression.getRightExpression().accept(this));
	}

	@SuppressWarnings("unchecked")
	protected <T extends Serializable> Expression<Boolean> transform(final NotEqual<T> expression) {
		return Binaries.notEqual((Expression<T>) expression.getLeftExpression().accept(this), (Expression<T>) expression.getRightExpression().accept(this));
	}

	@SuppressWarnings("unchecked")
	protected <T extends Serializable, M extends Matcher<T>> Expression<Boolean> transform(final Match<T, M> expression) {
		return Binaries.match((Expression<T>) expression.getLeftExpression().accept(this), (MatcherExpression<T, M>) expression.getRightExpression().accept(this));
	}

	@SuppressWarnings("unchecked")
	protected <T extends Serializable, M extends Matcher<T>> Expression<Boolean> transform(final NotMatch<T, M> expression) {
		return Binaries.notMatch((Expression<T>) expression.getLeftExpression().accept(this), (MatcherExpression<T, M>) expression.getRightExpression().accept(this));
	}

	protected <T extends CharSequence & Serializable> MatcherExpression<T, ? extends Matcher<T>> transform(final Pattern<T> expression) {
		return expression;
	}

	protected <T extends CharSequence & Serializable> MatcherExpression<T, ? extends Matcher<T>> transform(final Keyword<T> expression) {
		return expression;
	}
}
