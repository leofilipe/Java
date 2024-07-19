package com.github.leofilipe.rest.webservices.restful_web_services.user.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name = "user_details") // user is a keyword in H2, this avoids problems
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	@JsonProperty("user_name")
	@NotBlank(message = "Name should have at least 2 characters")
	@Size(min = 2, message = "Name should have at least 2 characters")
	private String name;

	@JsonProperty("birth_date")
	@NotNull(message = "Birth date should not be  null")
	@Past(message = "Birth Date should be in the past")
	private LocalDate birthDate;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Post> posts;
	
	protected User() {
	}

	public User(Integer id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	
}
