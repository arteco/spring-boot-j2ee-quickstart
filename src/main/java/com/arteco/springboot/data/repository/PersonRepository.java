package com.arteco.springboot.data.repository;

import com.arteco.springboot.data.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rarnau on 25/9/16.
 * Arteco Consulting Sl.
 * mailto: info@arteco-consulting.com
 */
public interface PersonRepository extends JpaRepository<Person,Long> {
}
