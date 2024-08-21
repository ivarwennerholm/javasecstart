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

    public List<Dog> getPublicDogs(){
        return dogRepository.findAllBySoldToIsNull();
    }

    public Dog getDogById(int id) {
        return dogRepository.findById((long) id).orElse(null);
    }

    public void updateDog(int id, String name, String breed, String age, String size, int price) {
        Dog dog = getDogById(id);
        dog.setName(name);
        dog.setBreed(breed);
        dog.setAge(age);
        dog.setSize(size);
        dog.setPrice(price);
        dogRepository.save(dog);
    }
}
