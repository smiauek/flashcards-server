package com.example.flashcards.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.flashcards.entities.UserEntity;
import com.example.flashcards.repositories.UserRepository;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepo;

	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//	@PostMapping("/new")
//	public Long saveUser(@RequestBody UserEntity user) {
//		UserEntity newUser = user;
//		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
//		return userRepo.save(newUser).getUserId();
//	}

	@PostMapping("/new")
	public ResponseEntity<UserEntity> saveUser(@Valid @RequestBody UserEntity user) {
		UserEntity newUser = user;
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		UserEntity savedUser = userRepo.save(newUser);
		return new ResponseEntity<UserEntity>(savedUser, HttpStatus.CREATED);
	}

	@GetMapping("/one")
	public UserEntity getUserByUsername(@RequestParam String username) {

		UserEntity foundUser = userRepo.findByUsername(username);

		UserEntity response = new UserEntity();

		response.setUserId(foundUser.getUserId());
		response.setUsername(foundUser.getUsername());
		response.setEmail(foundUser.getEmail());

		return response;
	}

}
