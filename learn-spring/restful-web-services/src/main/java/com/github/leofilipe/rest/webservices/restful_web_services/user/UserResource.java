package com.github.leofilipe.rest.webservices.restful_web_services.user;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.github.leofilipe.rest.webservices.restful_web_services.user.exception.UserNotFoundException;

import jakarta.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class UserResource {

	private UserDaoService service;

	public UserResource(UserDaoService service) {
		this.service = service;
	}

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {

		return service.findAll();
	}

//	@GetMapping(path = "/users/{id}")
//	public User retrieveUser(@PathVariable int id) {
//		User user = service.findOne(id);
//
//		if (user == null) {
//			throw new UserNotFoundException("id:" + id);
//		}
//
//		return user;
//	}

	// Besides doing the same as the original retrieveUser,
	// it employs HATEOAS, meaning it returns a link fron controlling the API
	// In this case, a link to return to all users
	// HATEOAS: Hypermedia as the Engine of Application State
	@GetMapping(path = "/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);

		if (user == null) {
			throw new UserNotFoundException("id:" + id);
		}

		EntityModel<User> entityModel = EntityModel.of(user);

		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());// WebMvcLinkBuilder
		// .linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());

		// the choice for the name "all-users" comes from HAL standard implementation
		// for JSON. Hence, it is not mandatory, but its an widely accepted standard.
		entityModel.add(link.withRel("all-users"));

		return entityModel;
	}

	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteById(id);

	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);

		// location - /users/id
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
