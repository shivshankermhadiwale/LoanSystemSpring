package com.dench.exception;

import java.time.LocalDateTime;

import org.apache.tomcat.jni.Local;

public class ExceptionDetails {
	private LocalDateTime timestamp;
	private String message;
	private String details;

	public ExceptionDetails( String message, String details) {
		this.timestamp = LocalDateTime.now();
		this.message = message;
		this.details = details;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
