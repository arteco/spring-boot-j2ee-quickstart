package com.arteco.springboot.service;

import com.arteco.springboot.data.dao.PersonDao;
import com.arteco.springboot.data.model.Address;
import com.arteco.springboot.data.model.Person;
import com.arteco.springboot.data.repository.AddressRepository;
import com.arteco.springboot.data.repository.PersonRepository;
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
	private PersonDao personDao;


	@PostConstruct
	public void init(){
		if (personDao.isEmpty()){
			Person p = new Person();
			p.setName("Ramón");
			p.setSurname("Arnau");
			personDao.save(p);

			Address address = new Address();
			address.setAccess("AT-B");
			address.setCity("Palma");
			address.setStreet("Av Alexandre Rosselló, 15");
			address.setPerson(p);
			personDao.save(address);
		}
	}

	public List<Person> getPeople() {
		return personDao.findAllPeople();
	}

	public List<Address> getAddresses(Long personId) {
		return personDao.findAddressByPersonId(personId);
	}
}
