package com.github.leofilipe.rest.webservices.restful_web_services.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.leofilipe.rest.webservices.restful_web_services.user.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
