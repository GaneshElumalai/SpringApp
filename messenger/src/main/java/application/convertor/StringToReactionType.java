package application.convertor;

import org.springframework.core.convert.converter.Converter;

import application.entity.ReactionType;


public class StringToReactionType implements Converter<String,ReactionType> {

	@Override
	public ReactionType convert(String reaction) {
		return ReactionType.valueOf(reaction);
	}
}
