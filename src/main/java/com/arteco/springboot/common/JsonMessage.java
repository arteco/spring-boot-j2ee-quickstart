package com.arteco.springboot.common;

/**
 * Created by rarnau on 25/9/16.
 * Arteco Consulting Sl.
 * mailto: info@arteco-consulting.com
 */
public class JsonMessage {
	private String value;

	public JsonMessage() {
	}

	public JsonMessage(String s) {
		this.value = s;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
