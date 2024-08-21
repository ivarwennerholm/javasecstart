package se.systementor.javasecstart.model;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {

    List<Dog> findAllBySoldToIsNull();

    //@Query()
    @Query("select cc from Dog cc where cc.name= :searchTerm")
    List<Dog> findAllSearchDog(@Param("searchTerm") String searchTerm);

    List<Dog> findAll(Sort sort);
}