package com.github.t3t5u.common.expression;

@SuppressWarnings("serial")
public class CharacterLiteral extends AbstractLiteralExpression<Character> {
	CharacterLiteral(final Character value) {
		super(Character.class, value);
	}

	@Override
	public <R> R accept(final Visitor<R> visitor) {
		return visitor.visit(this);
	}
}
