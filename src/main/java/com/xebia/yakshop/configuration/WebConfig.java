package com.xebia.yakshop.configuration;

import javax.servlet.Filter;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration 
@Configuration
public class WebConfig{

	@Bean
	public Filter cORSFilter(){
		return new CORSFilter();
	}
}
