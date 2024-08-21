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
}
