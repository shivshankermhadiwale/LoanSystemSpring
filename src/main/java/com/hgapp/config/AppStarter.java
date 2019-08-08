package com.hgapp.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableAutoConfiguration
@ComponentScan(basePackages = "com.hgapp")
@EnableJpaRepositories("com.hgapp")
@EntityScan("com.hgapp.entity")
//@EnableZuulProxy
public class AppStarter extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AppStarter.class);
	}

	
	public static void main(String[] args) {
		SpringApplication.run(AppStarter.class, args);
	}
	
	/*@Bean
	  public ZoolFilterConfig simpleFilter() {
	     return new ZoolFilterConfig();
	  }*/

}
