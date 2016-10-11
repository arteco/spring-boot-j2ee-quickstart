package com.arteco.springboot.service;

import com.arteco.springboot.data.dao.UserDao;
import com.arteco.springboot.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Developed by Arteco Consulting Sl.
 * Author rarnau on 11/10/16.
 */
@Service
public class IMIUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findOne(username);
        if (user == null ||
            user.getActive()==null ||
            !user.getActive() ||
            user.getRoles()==null ||
            user.getRoles().size()==0){
            throw new UsernameNotFoundException("Username "+username+" not found or is inactive");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (String rol : user.getRoles()){
            authorities.add(new SimpleGrantedAuthority(rol));
        }

        return new org.springframework.security.core.userdetails.User(
                username,
                user.getPassword(),
                authorities
        );
    }

}
