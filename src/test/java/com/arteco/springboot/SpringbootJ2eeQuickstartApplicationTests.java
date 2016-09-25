package com.arteco.springboot;

import com.arteco.springboot.data.PersonDao;
import com.arteco.springboot.model.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJ2eeQuickstartApplicationTests {

	@Autowired
	private PersonDao personDao;

	@Test
	public void contextLoads() {
		List<Person> people = personDao.findPeopleByTerm("a");
		Assert.assertTrue(people.size() > 0);
	}

}
