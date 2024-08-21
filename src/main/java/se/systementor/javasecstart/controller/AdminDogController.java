package se.systementor.javasecstart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import se.systementor.javasecstart.model.Dog;
import se.systementor.javasecstart.services.DogService;

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
    @RequestMapping("/admin/dogs/edit/{id}")
    protected String updateForm(@PathVariable int id, Model model){
        Dog dog = dogService.getDogById(id);
        model.addAttribute("dog",dog);
        return "editDog.html";
    }

}
