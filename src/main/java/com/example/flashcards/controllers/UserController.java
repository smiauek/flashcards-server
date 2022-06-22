package com.example.flashcards.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.flashcards.entities.CardEntity;
import com.example.flashcards.entities.DeckEntity;
import com.example.flashcards.entities.UserEntity;
import com.example.flashcards.repositories.UserRepository;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepo;

	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@PostMapping("/new")
	public Long saveUser(@RequestBody UserEntity user) {
		UserEntity newUser = user;
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(newUser).getUserId();
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
