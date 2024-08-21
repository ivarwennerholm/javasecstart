package se.systementor.javasecstart.model;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {

    List<Dog> findAllBySoldToIsNull();

    List<Dog> findAll(Sort sort);
}