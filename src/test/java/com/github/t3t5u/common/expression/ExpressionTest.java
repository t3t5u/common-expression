package com.github.t3t5u.common.expression;

import static com.github.t3t5u.common.expression.Binaries.*;
import static com.github.t3t5u.common.expression.Literals.*;
import static com.github.t3t5u.common.expression.Matchers.*;
import static com.github.t3t5u.common.expression.Unaries.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.regex.Pattern;

import org.junit.Test;

public class ExpressionTest {
	@Test
	public void testEvaluate() {
		final Transformer transformer = new Transformer() {
		};
		assertThat(evaluate(transformer, not(and(or(asBoolean(true), asBoolean(false)), asBoolean(true)))), is(false));
		assertThat(evaluate(transformer, not(and(or(equal(asString("a"), asString("a")), notEqual(asString("b"), asString("b"))), asBoolean(true)))), is(false));
		assertThat(evaluate(transformer, not(and(or(equal(asString("a"), asString("b")), notEqual(asString("a"), asString("b"))), asBoolean(true)))), is(false));
		assertThat(evaluate(transformer, not(and(or(lessThan(asInteger(1), asInteger(2)), greaterThanOrEqual(asInteger(1), asInteger(2))), asBoolean(true)))), is(false));
		assertThat(evaluate(transformer, not(and(or(lessThan(add(asInteger(1), asInteger(1)), asInteger(2)), greaterThanOrEqual(add(asInteger(1), asInteger(1)), asInteger(2))), asBoolean(true)))), is(false));
		assertThat(evaluate(transformer, not(and(or(lessThan(subtract(asInteger(1), asInteger(1)), asInteger(2)), greaterThanOrEqual(subtract(asInteger(1), asInteger(1)), asInteger(2))), asBoolean(true)))), is(false));
		assertThat(evaluate(transformer, not(and(or(lessThan(divide(asInteger(1), asInteger(1)), asInteger(2)), greaterThanOrEqual(divide(asInteger(1), asInteger(1)), asInteger(2))), asBoolean(true)))), is(false));
		assertThat(evaluate(transformer, not(and(or(lessThan(multiply(asInteger(1), asInteger(1)), asInteger(2)), greaterThanOrEqual(multiply(asInteger(1), asInteger(1)), asInteger(2))), asBoolean(true)))), is(false));
		assertThat(evaluate(transformer, not(and(or(greaterThan(asInteger(1), asInteger(2)), lessThanOrEqual(asInteger(1), asInteger(2))), asBoolean(true)))), is(false));
		assertThat(evaluate(transformer, not(and(or(greaterThan(add(asInteger(1), asInteger(1)), asInteger(2)), lessThanOrEqual(add(asInteger(1), asInteger(1)), asInteger(2))), asBoolean(true)))), is(false));
		assertThat(evaluate(transformer, not(and(or(greaterThan(subtract(asInteger(1), asInteger(1)), asInteger(2)), lessThanOrEqual(subtract(asInteger(1), asInteger(1)), asInteger(2))), asBoolean(true)))), is(false));
		assertThat(evaluate(transformer, not(and(or(greaterThan(divide(asInteger(1), asInteger(1)), asInteger(2)), lessThanOrEqual(divide(asInteger(1), asInteger(1)), asInteger(2))), asBoolean(true)))), is(false));
		assertThat(evaluate(transformer, not(and(or(greaterThan(multiply(asInteger(1), asInteger(1)), asInteger(2)), lessThanOrEqual(multiply(asInteger(1), asInteger(1)), asInteger(2))), asBoolean(true)))), is(false));
		assertThat(evaluate(transformer, not(and(or(lessThan(asBigDecimal(new BigDecimal(1)), asBigDecimal(new BigDecimal(2))), greaterThanOrEqual(asBigDecimal(new BigDecimal(1)), asBigDecimal(new BigDecimal(2)))), asBoolean(true)))), is(false));
		assertThat(evaluate(transformer, not(and(or(lessThan(add(asBigDecimal(new BigDecimal(1)), asBigDecimal(new BigDecimal(1))), asBigDecimal(new BigDecimal(2))), greaterThanOrEqual(add(asBigDecimal(new BigDecimal(1)), asBigDecimal(new BigDecimal(1))), asBigDecimal(new BigDecimal(2)))), asBoolean(true)))),
				is(false));
		assertThat(
				evaluate(transformer, not(and(or(lessThan(subtract(asBigDecimal(new BigDecimal(1)), asBigDecimal(new BigDecimal(1))), asBigDecimal(new BigDecimal(2))), greaterThanOrEqual(subtract(asBigDecimal(new BigDecimal(1)), asBigDecimal(new BigDecimal(1))), asBigDecimal(new BigDecimal(2)))), asBoolean(true)))),
				is(false));
		assertThat(evaluate(transformer, not(and(or(lessThan(divide(asBigDecimal(new BigDecimal(1)), asBigDecimal(new BigDecimal(1))), asBigDecimal(new BigDecimal(2))), greaterThanOrEqual(divide(asBigDecimal(new BigDecimal(1)), asBigDecimal(new BigDecimal(1))), asBigDecimal(new BigDecimal(2)))), asBoolean(true)))),
				is(false));
		assertThat(
				evaluate(transformer, not(and(or(lessThan(multiply(asBigDecimal(new BigDecimal(1)), asBigDecimal(new BigDecimal(1))), asBigDecimal(new BigDecimal(2))), greaterThanOrEqual(multiply(asBigDecimal(new BigDecimal(1)), asBigDecimal(new BigDecimal(1))), asBigDecimal(new BigDecimal(2)))), asBoolean(true)))),
				is(false));
		assertThat(evaluate(transformer, not(and(or(greaterThan(asBigDecimal(new BigDecimal(1)), asBigDecimal(new BigDecimal(2))), lessThanOrEqual(asBigDecimal(new BigDecimal(1)), asBigDecimal(new BigDecimal(2)))), asBoolean(true)))), is(false));
		assertThat(evaluate(transformer, not(and(or(greaterThan(add(asBigDecimal(new BigDecimal(1)), asBigDecimal(new BigDecimal(1))), asBigDecimal(new BigDecimal(2))), lessThanOrEqual(add(asBigDecimal(new BigDecimal(1)), asBigDecimal(new BigDecimal(1))), asBigDecimal(new BigDecimal(2)))), asBoolean(true)))),
				is(false));
		assertThat(
				evaluate(transformer, not(and(or(greaterThan(subtract(asBigDecimal(new BigDecimal(1)), asBigDecimal(new BigDecimal(1))), asBigDecimal(new BigDecimal(2))), lessThanOrEqual(subtract(asBigDecimal(new BigDecimal(1)), asBigDecimal(new BigDecimal(1))), asBigDecimal(new BigDecimal(2)))), asBoolean(true)))),
				is(false));
		assertThat(evaluate(transformer, not(and(or(greaterThan(divide(asBigDecimal(new BigDecimal(1)), asBigDecimal(new BigDecimal(1))), asBigDecimal(new BigDecimal(2))), lessThanOrEqual(divide(asBigDecimal(new BigDecimal(1)), asBigDecimal(new BigDecimal(1))), asBigDecimal(new BigDecimal(2)))), asBoolean(true)))),
				is(false));
		assertThat(
				evaluate(transformer, not(and(or(greaterThan(multiply(asBigDecimal(new BigDecimal(1)), asBigDecimal(new BigDecimal(1))), asBigDecimal(new BigDecimal(2))), lessThanOrEqual(multiply(asBigDecimal(new BigDecimal(1)), asBigDecimal(new BigDecimal(1))), asBigDecimal(new BigDecimal(2)))), asBoolean(true)))),
				is(false));
		assertThat(evaluate(transformer, not(and(or(match(asString("a"), pattern(Pattern.compile("^a$"))), notMatch(asString("b"), pattern(Pattern.compile("^b$")))), asBoolean(true)))), is(false));
		assertThat(evaluate(transformer, not(and(or(match(asString("a"), pattern(Pattern.compile("^b$"))), notMatch(asString("a"), pattern(Pattern.compile("^b$")))), asBoolean(true)))), is(false));
		assertThat(evaluate(transformer, not(and(or(match(asString("a"), keyword("a", MatchType.PARTIAL)), notMatch(asString("b"), keyword("b", MatchType.PARTIAL))), asBoolean(true)))), is(false));
		assertThat(evaluate(transformer, not(and(or(match(asString("a"), keyword("b", MatchType.PARTIAL)), notMatch(asString("a"), keyword("b", MatchType.PARTIAL))), asBoolean(true)))), is(false));
		assertThat(evaluate(transformer, not(and(or(asBoolean(null), asBoolean(null)), asBoolean(null)))), is(nullValue()));
		assertThat(evaluate(transformer, not(and(or(equal(asString(null), asString(null)), notEqual(asString(null), asString(null))), asBoolean(null)))), is(nullValue()));
		assertThat(evaluate(transformer, not(and(or(lessThan(asInteger(null), asInteger(null)), greaterThanOrEqual(asInteger(null), asInteger(null))), asBoolean(null)))), is(nullValue()));
		assertThat(evaluate(transformer, not(and(or(lessThan(add(asInteger(null), asInteger(null)), asInteger(null)), greaterThanOrEqual(add(asInteger(null), asInteger(null)), asInteger(null))), asBoolean(null)))), is(nullValue()));
		assertThat(evaluate(transformer, not(and(or(lessThan(subtract(asInteger(null), asInteger(null)), asInteger(null)), greaterThanOrEqual(subtract(asInteger(null), asInteger(null)), asInteger(null))), asBoolean(null)))), is(nullValue()));
		assertThat(evaluate(transformer, not(and(or(lessThan(divide(asInteger(null), asInteger(null)), asInteger(null)), greaterThanOrEqual(divide(asInteger(null), asInteger(null)), asInteger(null))), asBoolean(null)))), is(nullValue()));
		assertThat(evaluate(transformer, not(and(or(lessThan(multiply(asInteger(null), asInteger(null)), asInteger(null)), greaterThanOrEqual(multiply(asInteger(null), asInteger(null)), asInteger(null))), asBoolean(null)))), is(nullValue()));
		assertThat(evaluate(transformer, not(and(or(greaterThan(asInteger(null), asInteger(null)), lessThanOrEqual(asInteger(null), asInteger(null))), asBoolean(null)))), is(nullValue()));
		assertThat(evaluate(transformer, not(and(or(greaterThan(add(asInteger(null), asInteger(null)), asInteger(null)), lessThanOrEqual(add(asInteger(null), asInteger(null)), asInteger(null))), asBoolean(null)))), is(nullValue()));
		assertThat(evaluate(transformer, not(and(or(greaterThan(subtract(asInteger(null), asInteger(null)), asInteger(null)), lessThanOrEqual(subtract(asInteger(null), asInteger(null)), asInteger(null))), asBoolean(null)))), is(nullValue()));
		assertThat(evaluate(transformer, not(and(or(greaterThan(divide(asInteger(null), asInteger(null)), asInteger(null)), lessThanOrEqual(divide(asInteger(null), asInteger(null)), asInteger(null))), asBoolean(null)))), is(nullValue()));
		assertThat(evaluate(transformer, not(and(or(greaterThan(multiply(asInteger(null), asInteger(null)), asInteger(null)), lessThanOrEqual(multiply(asInteger(null), asInteger(null)), asInteger(null))), asBoolean(null)))), is(nullValue()));
	}

	@SuppressWarnings("unchecked")
	private static <T extends Serializable> T evaluate(final Transformer transformer, final Expression<T> expression) {
		return (T) expression.accept(transformer).evaluate();
	}
}
