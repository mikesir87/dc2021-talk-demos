package io.mikesir87.dc2021demo;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Dc2021DemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(Dc2021DemoApplication.class);

	@Value("${corsOrigins}")
	private String corsOrigins;

	public static void main(String[] args) {
		SpringApplication.run(Dc2021DemoApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		logger.info("Configuring CORS to use {}", corsOrigins);
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins(corsOrigins.split(","))
						.allowedMethods("GET", "POST", "PUT", "DELETE");
			}
		};
	}
}
