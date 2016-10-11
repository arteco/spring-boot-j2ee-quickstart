package com.arteco.springboot.data.repository;

import com.arteco.springboot.data.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by rarnau on 25/9/16.
 * Arteco Consulting Sl.
 * mailto: info@arteco-consulting.com
 */
public interface AddressRepository extends JpaRepository<Address,Long> {
	List<Address> findByPersonId(Long personId);
}
