package com.github.leofilipe.rest.webservices.restful_web_services.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.leofilipe.rest.webservices.restful_web_services.user.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
