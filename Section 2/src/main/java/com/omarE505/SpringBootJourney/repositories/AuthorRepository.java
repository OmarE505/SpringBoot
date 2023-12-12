package com.omarE505.SpringBootJourney.repositories;

import com.omarE505.SpringBootJourney.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
