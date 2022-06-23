package com.example.flashcards.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
@DiscriminatorValue("users")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;

	@Column(name = "username", nullable = false, unique = true)
	@NotEmpty(message = "username must not be empty")
	@Size(min = 4, message = "username should have at least 4 characters")
	private String username;

	@Column(name = "email", nullable = false, unique = true)
	@NotEmpty(message = "email must not be empty")
	@Email(message = "email should be formatted properly - example@example.com")
	private String email;

	@Column(name = "password", nullable = false)
	@NotEmpty(message = "password must not be empty")
	@Size(min = 4, message = "password should have at least 4 characters")
	private String password;

	public UserEntity() {

	}

	public UserEntity(String username, String email, String password) {

		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long id) {
		this.userId = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", username=" + username + ", email=" + email + ", password=" + password
				+ "]";
	}

}
