package com.example.flashcards.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.flashcards.entities.DeckEntity;

@Repository
public interface DeckRepository extends JpaRepository<DeckEntity, Long> {

	List<DeckEntity> findByUserId(Long id);

	List<DeckEntity> findByNameContainsOrDescriptionContains(String searchTerm1, String searchTerm2);

}
