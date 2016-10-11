package com.arteco.springboot.data.dao;

import com.arteco.springboot.data.model.User;
import com.arteco.springboot.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by rarnau on 25/9/16.
 * Arteco Consulting Sl.
 * mailto: info@arteco-consulting.com
 */
@Component
public class UserDao {

	@Autowired
	private UserRepository userRepository;

	public User findOne(String username) {
		return userRepository.findOne(username);
	}
}
