package com.arteco.springboot.data.dao;

import com.arteco.springboot.data.model.Address;
import com.arteco.springboot.data.model.Person;
import com.arteco.springboot.data.model.QPerson;
import com.arteco.springboot.data.repository.AddressRepository;
import com.arteco.springboot.data.repository.PersonRepository;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rarnau on 25/9/16.
 * Arteco Consulting Sl.
 * mailto: info@arteco-consulting.com
 */
@Component
public class PersonDao {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private PersonRepository personRepository;

	public List<Person> findPeopleByTerm(String term){
		if(term == null || term.length()<1){
			return new ArrayList<>();
		}
		term = "%"+term+"%";
		QPerson person = QPerson.person;
		JPAQuery<Person> query = new JPAQuery<>(entityManager);
		query.from(person).where(person.name.likeIgnoreCase(term)
				.or(person.surname.likeIgnoreCase(term)));
		return query.fetch();
	}

	public boolean isEmpty() {
		return personRepository.count() == 0;
	}

	public void save(Person p) {
		personRepository.save(p);
	}

	public void save(Address address) {
		addressRepository.save(address);
	}

	public List<Person> findAllPeople() {
		return personRepository.findAll();
	}

	public List<Address> findAddressByPersonId(Long personId) {
		return addressRepository.findByPersonId(personId);
	}
}
