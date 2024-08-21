package se.systementor.javasecstart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.systementor.javasecstart.model.Dog;
import se.systementor.javasecstart.services.DogService;

import java.util.List;

@Controller
public class AdminDogController {
    @Autowired
    private DogService dogService;
    @GetMapping(path="/admin/dogs")
    String list(Model model){
        model.addAttribute("activeFunction", "home");
//        setupVersion(model);

        model.addAttribute("dogs", dogService.getPublicDogs());
        return "admin/dogs/list";
    }

    @GetMapping(path = "/admin/dogs/search")
    String search(Model model,
        @RequestParam(defaultValue = "") String q) {
        List<Dog> searchDogList = dogService.getSearchDogs(q);
        model.addAttribute("q",searchDogList);

        return "list";
    }

}
