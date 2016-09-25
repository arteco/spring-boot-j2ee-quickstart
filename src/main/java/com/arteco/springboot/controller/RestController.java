package com.arteco.springboot.controller;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by rarnau on 25/9/16.
 * Arteco Consulting Sl.
 * mailto: info@arteco-consulting.com
 */
@Component
@Path("/api")
public class RestController {

	@GET
	@Path("/hello")
	public String test() {
		return "Hello world!";

	}

}