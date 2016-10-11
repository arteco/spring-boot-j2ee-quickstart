package com.arteco.springboot.web.controller;

import com.arteco.springboot.common.JsonMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rarnau on 25/9/16.
 * Arteco Consulting Sl.
 * mailto: info@arteco-consulting.com
 */
@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class IndexRestController {

	@RequestMapping(value = "/public/hello", method = RequestMethod.GET)
	public JsonMessage publicMethod() {
		return new JsonMessage("Hello world!");

	}

	@RequestMapping(value = "/admin/hello", method = RequestMethod.GET)
	public JsonMessage protectedMethod() {
		return new JsonMessage("Hello world from secured resource!");

	}

}