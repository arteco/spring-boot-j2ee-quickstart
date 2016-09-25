package com.arteco.springboot.controller;

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

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public JsonMessage test() {
		return new JsonMessage("Hello world!");

	}

}