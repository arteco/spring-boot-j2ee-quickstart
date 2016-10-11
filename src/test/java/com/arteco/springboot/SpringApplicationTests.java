package com.arteco.springboot;

import com.arteco.springboot.data.dao.PersonDao;
import com.arteco.springboot.data.model.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("devel")
public class SpringApplicationTests {

	@Autowired
	private PersonDao personDao;

	@Test
	public void contextLoads() {
		List<Person> people = personDao.findPeopleByTerm("a");
		Assert.assertTrue(people.size() > 0);
	}

}
