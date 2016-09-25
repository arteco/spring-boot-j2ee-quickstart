package com.arteco.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by rarnau on 25/9/16.
 * Arteco Consulting Sl.
 * mailto: info@arteco-consulting.com
 */
@Controller
public class IndexController {

	@RequestMapping("")
	public String index(Model model){
		model.addAttribute("message","Hello World");
		return "index";
	}
}
