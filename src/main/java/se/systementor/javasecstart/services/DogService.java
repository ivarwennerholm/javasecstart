package se.systementor.javasecstart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.systementor.javasecstart.model.Dog;
import se.systementor.javasecstart.model.DogRepository;

import java.util.List;

@Service
public class DogService {
    @Autowired
    DogRepository dogRepository;

    public List<Dog> getSearchDogs(String q) {
        return dogRepository.findAllSearchDog(q);
    }

    public List<Dog> getPublicDogs(){
        return dogRepository.findAllBySoldToIsNull();
    }
}
