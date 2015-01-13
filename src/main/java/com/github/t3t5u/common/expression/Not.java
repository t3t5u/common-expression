package com.github.t3t5u.common.expression;

import org.apache.commons.lang3.BooleanUtils;

import com.github.t3t5u.common.util.ExtraObjectUtils;

@SuppressWarnings("serial")
public class Not extends AbstractUnaryExpression<Boolean, Boolean> implements LogicalExpression {
	Not(final Expression<Boolean> expression) {
		super(Boolean.class, expression);
	}

	@Override
	public Boolean evaluate() {
		final Boolean bool = getExpression().evaluate();
		return bool != null ? BooleanUtils.negate(bool) : ExtraObjectUtils.<Boolean> asNull();
	}

	@Override
	public <R> R accept(final Visitor<R> visitor) {
		return visitor.visit(this);
	}
}
