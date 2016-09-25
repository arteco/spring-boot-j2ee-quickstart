package com.arteco.springboot.service;

import com.arteco.springboot.model.Address;
import com.arteco.springboot.model.Person;
import com.arteco.springboot.repository.AddressRepository;
import com.arteco.springboot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by rarnau on 25/9/16.
 * Arteco Consulting Sl.
 * mailto: info@arteco-consulting.com
 */
@Service
@SuppressWarnings("unused")
public class PersonService {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private PersonRepository personRepository;


	@PostConstruct
	public void init(){
		if (personRepository.count()==0){
			Person p = new Person();
			p.setName("Ramón");
			p.setSurname("Arnau");
			personRepository.save(p);

			Address address = new Address();
			address.setAccess("AT-B");
			address.setCity("Palma");
			address.setStreet("Av Alexandre Rosselló, 15");
			address.setPerson(p);
			addressRepository.save(address);
		}
	}

	public List<Person> getPeople() {
		return personRepository.findAll();
	}

	public List<Address> getAddresses(Long personId) {
		return addressRepository.findByPersonId(personId);
	}
}
