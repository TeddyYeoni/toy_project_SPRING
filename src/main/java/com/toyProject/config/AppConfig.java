package com.toyProject.config;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new ByteArrayHttpMessageConverter());
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setDefaultCharset(Charset.forName("UTF-8"));
		converters.add(converter);
	}

	public class MultipartToStringConverter implements Converter<MultipartFile, String> {
		@Override
		public String convert(MultipartFile multipartFile) {
			return multipartFile.getOriginalFilename();
		}
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new MultipartToStringConverter());
	}
}