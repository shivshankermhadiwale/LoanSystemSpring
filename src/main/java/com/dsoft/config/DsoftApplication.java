package com.dsoft.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.dsoft")
@EnableJpaRepositories("com.dsoft")
@EntityScan("com.dsoft.entity")
//@EnableZuulProxy
public class DsoftApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DsoftApplication.class);
	}

	
	public static void main(String[] args) {
		SpringApplication.run(DsoftApplication.class, args);
	}
	
	/*@Bean
	  public ZoolFilterConfig simpleFilter() {
	     return new ZoolFilterConfig();
	  }*/

}
