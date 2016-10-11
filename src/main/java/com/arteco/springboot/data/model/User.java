package com.arteco.springboot.data.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Developed by Arteco Consulting Sl.
 * Author rarnau on 11/10/16.
 */
@Entity
@Table(uniqueConstraints =
    @UniqueConstraint(columnNames = {"username"})
)
public class User {

    @Id
    @NotNull
    @Length(min=5,max=15)
    private String username;

    @NotNull
    @Length(min=5,max=15)
    private String password;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    private Set<String> roles;

    private Boolean active = true;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
