package com.github.leofilipe.rest.webservices.restful_web_services.user.jpa;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.github.leofilipe.rest.webservices.restful_web_services.user.exception.UserNotFoundException;
import com.github.leofilipe.rest.webservices.restful_web_services.user.model.Post;
import com.github.leofilipe.rest.webservices.restful_web_services.user.model.User;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {

	private UserRepository userResp;

	private PostRepository postRep;

	public UserJpaResource(UserRepository userResp, PostRepository postRep) {
		this.userResp = userResp;
		this.postRep = postRep;
	}

	@GetMapping({"/jpa/users", "/jpa/users/"})
	public List<User> retrieveAllUsers() {

		return userResp.findAll();
	}

	// Besides doing the same as the original retrieveUser,
	// it employs HATEOAS, meaning it returns a link fron controlling the API
	// In this case, a link to return to all users
	// HATEOAS: Hypermedia as the Engine of Application State
	@GetMapping(path = "/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = userResp.findById(id);

		if (user.isEmpty()) {
			throw new UserNotFoundException("id:" + id);
		}

		EntityModel<User> entityModel = EntityModel.of(user.get());

		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());// WebMvcLinkBuilder
		// .linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());

		// the choice for the name "all-users" comes from HAL standard implementation
		// for JSON. Hence, it is not mandatory, but its an widely accepted standard.
		entityModel.add(link.withRel("all-users"));

		return entityModel;
	}

	@DeleteMapping(path = "/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userResp.deleteById(id);

	}

	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = userResp.save(user);

		// location - /users/id
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/jpa/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveAllPostsForUser(@PathVariable int id) {

		Optional<User> user = userResp.findById(id);

		if (user.isEmpty()) {
			throw new UserNotFoundException("id:" + id);
		}

		List<Post> posts = user.get().getPosts();

		// EntityModel<User> entityModel = EntityModel.of(user.get());

		return posts;
	}

	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Post> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post) {

		Optional<User> user = userResp.findById(id);

		if (user.isEmpty()) {
			throw new UserNotFoundException("id:" + id);
		}

		post.setUser(user.get());
		
		Post savedPost = postRep.save(post);

		// location - /users/id
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedPost.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
