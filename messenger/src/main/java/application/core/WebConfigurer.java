package application.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import application.convertor.StringToReactionType;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new StringToReactionType());
//		WebMvcConfigurer.super.addFormatters(registry);
	}
}
