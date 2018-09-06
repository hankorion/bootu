package com.durain.bootu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BootuApplication extends SpringBootServletInitializer {
	private final static Logger logger = LoggerFactory.getLogger(BootuApplication.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(BootuApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(BootuApplication.class, args);
		logger.info("BootuApplication [activity-web] started!");
	}
}
