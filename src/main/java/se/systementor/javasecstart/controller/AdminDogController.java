package se.systementor.javasecstart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.systementor.javasecstart.model.Dog;
import se.systementor.javasecstart.model.DogRepository;
import se.systementor.javasecstart.services.DogService;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class AdminDogController {
    @Autowired
    private DogService dogService;
    @Autowired
    private DogRepository dogRepository;

    @GetMapping(path = "/admin/dogs")
    String list(Model model) {
        model.addAttribute("activeFunction", "home");
//        setupVersion(model);

        model.addAttribute("dogs", dogService.getPublicDogs());
        return "admin/dogs/list";
    }

    @RequestMapping("/admin/dogs/edit/{id}")
    protected String editForm(@PathVariable int id, Model model) {
        Dog dog = dogService.getDogById(id);
        model.addAttribute("dog", dog);
        return "admin/dogs/edit";
    }

    @PostMapping("admin/dogs/update/{id}")
    protected String updateDog(@PathVariable int id,
                               @RequestParam String name,
                               @RequestParam String breed,
                               @RequestParam String age,
                               @RequestParam String size,
                               @RequestParam int price) {

        dogService.updateDog(id, name, breed, age, size, price);
        return "redirect:/admin/dogs";
    }


}
