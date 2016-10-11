package com.arteco.springboot.data.repository;

import com.arteco.springboot.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rarnau on 25/9/16.
 * Arteco Consulting Sl.
 * mailto: info@arteco-consulting.com
 */
public interface UserRepository extends JpaRepository<User,String> {
}
