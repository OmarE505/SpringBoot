package com.omarE505.SpringBootJourney.repositories;

import com.omarE505.SpringBootJourney.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
