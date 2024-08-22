package se.systementor.javasecstart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    public List<Dog> getSort(Sort sortCol){
        return dogRepository.findAll(sortCol);
    }

    public List<Dog> getSearchDogList(String keyword){
        return dogRepository.findSearchDogs(keyword);
    }

    public List<Dog> serachAndSort(String q, String sortCol, String sortOrder){

        List<Dog> list = null;
        if (q != null && sortCol != null && sortOrder != null){
            Sort sort = Sort.by(Sort.Order.by(sortCol).with(Sort.Direction.fromString(sortOrder)));
            return list = dogRepository.findBySearchAndSort(q,sort);
        } else if (q != null){
            return list = dogRepository.findSearchDogs(q);
        }
        return getPublicDogs();
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
