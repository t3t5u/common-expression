package com.github.t3t5u.common.expression;

import java.io.Serializable;

public interface Visitor<R> {
	<T extends Serializable> R visit(NullLiteral<T> expression);

	R visit(BooleanLiteral expression);

	<T extends Number> R visit(NumberLiteral<T> expression);

	R visit(CharacterLiteral expression);

	<T extends CharSequence & Serializable> R visit(CharSequenceLiteral<T> expression);

	<T extends Enum<T>> R visit(EnumLiteral<T> expression);

	R visit(DateLiteral expression);

	R visit(Not expression);

	<T extends Number> R visit(Negate<T> expression);

	R visit(And expression);

	R visit(Or expression);

	<T extends Number> R visit(Add<T> expression);

	<T extends Number> R visit(Subtract<T> expression);

	<T extends Number> R visit(Divide<T> expression);

	<T extends Number> R visit(Multiply<T> expression);

	<T extends Comparable<T> & Serializable> R visit(LessThan<T> expression);

	<T extends Comparable<T> & Serializable> R visit(LessThanOrEqual<T> expression);

	<T extends Comparable<T> & Serializable> R visit(GreaterThan<T> expression);

	<T extends Comparable<T> & Serializable> R visit(GreaterThanOrEqual<T> expression);

	<T extends Serializable> R visit(Equal<T> expression);

	<T extends Serializable> R visit(NotEqual<T> expression);

	<T extends Serializable, M extends Matcher<T>> R visit(Match<T, M> expression);

	<T extends Serializable, M extends Matcher<T>> R visit(NotMatch<T, M> expression);

	<T extends CharSequence & Serializable> R visit(Pattern<T> expression);

	<T extends CharSequence & Serializable> R visit(Keyword<T> expression);
}
