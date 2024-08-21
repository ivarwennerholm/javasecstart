package se.systementor.javasecstart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.systementor.javasecstart.model.Dog;
import se.systementor.javasecstart.model.DogRepository;

import java.util.List;

@Controller
public class AdminDogController {
    @Autowired
    private DogRepository dogRepository;

    /*
    @GetMapping(path="/admin/dogs")
    String list(Model model){
        model.addAttribute("activeFunction", "home");
//        setupVersion(model);

        model.addAttribute("dogs", dogService.getPublicDogs());
        return "admin/dogs/list";
    }

     */

    @GetMapping(path="/admin/dogs")
    String sort(Model model,
                @RequestParam(defaultValue = "name") String sortCol,
                @RequestParam(defaultValue = "ASC") String sortOrder,
                @RequestParam(defaultValue = "") String q)
    {

        model.addAttribute("q", q);
        Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortCol);

        List<Dog> list =  dogRepository.findAll(sort);
        model.addAttribute("dogs", list);

        return "/admin/dogs/list";
    }

}
