package com.arteco.springboot.web.controller;

import com.arteco.springboot.data.model.Address;
import com.arteco.springboot.data.model.Person;
import com.arteco.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by rarnau on 25/9/16.
 * Arteco Consulting Sl.
 * mailto: info@arteco-consulting.com
 */
@Controller
@SuppressWarnings("unused")
public class IndexController {

	@Autowired
	private PersonService personService;

	@RequestMapping("")
	public String index(Model model){
		List<Person> people = personService.getPeople();
		if (people.size()>0){
			Long personId = people.get(0).getId();
			List<Address> addresses = personService.getAddresses(personId);
			model.addAttribute("addresses", addresses);
		}
		model.addAttribute("people",people);
		model.addAttribute("message","Hello World");
		return "index";
	}
}
