package com.hgapp.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
@PropertySource("classpath:application.properties")
public class PropertyFileUtil {
	@Value("${skip.security.endpoints}")
	private String skipSecurityEndpoints;

	public String getSkipSecurityEndpoints() {
		return skipSecurityEndpoints;
	}

	public void setSkipSecurityEndpoints(String skipSecurityEndpoints) {
		this.skipSecurityEndpoints = skipSecurityEndpoints;
	}

}
