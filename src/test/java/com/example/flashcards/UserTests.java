package com.example.flashcards;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.flashcards.entities.UserEntity;
import com.example.flashcards.repositories.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	UserRepository userRepo;

	@Test
	public void findNoUsersIfRepoIsEmpty() {
		Iterable<UserEntity> users = userRepo.findAll();

		assertThat(users).isEmpty();
	}

	@Test
	public void saveUser() {
		UserEntity user = userRepo.save(new UserEntity("peter", "peter@peter.com", "peter"));

		assertThat(user).hasFieldOrPropertyWithValue("username", "peter");

	}

	@Test
	public void deleteAllUsers() {
		entityManager.persist(new UserEntity("peter", "peter@peter.com", "peter"));
		entityManager.persist(new UserEntity("peter2", "peter2@peter.com", "peter2"));

		userRepo.deleteAll();

		assertThat(userRepo.findAll()).isEmpty();
	}

	@Test
	public void findAllUsers() {
		UserEntity user1 = new UserEntity("peter", "peter@peter.com", "peter");
		entityManager.persist(user1);

		UserEntity user2 = new UserEntity("peter2", "peter2@peter.com", "peter2");
		entityManager.persist(user2);

		Iterable<UserEntity> users = userRepo.findAll();

		assertThat(users).hasSize(2).contains(user1, user2);
	}

	@Test
	public void findUserByUsername() {
		UserEntity user1 = new UserEntity("peter", "peter@peter.com", "peter");
		entityManager.persist(user1);

		UserEntity user2 = new UserEntity("peter2", "peter2@peter.com", "peter2");
		entityManager.persist(user2);

		UserEntity user = userRepo.findByUsername(user2.getUsername());

		assertThat(user).isEqualTo(user2);
	}

}
