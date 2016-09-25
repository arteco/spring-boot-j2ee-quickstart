package com.arteco.springboot.data;

import com.arteco.springboot.model.Person;
import com.arteco.springboot.model.QPerson;
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
}
