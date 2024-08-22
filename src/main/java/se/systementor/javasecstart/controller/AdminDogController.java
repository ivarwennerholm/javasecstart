package se.systementor.javasecstart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

//    Search & sort -- undergoing
@GetMapping(path="/admin/dogs")
String search(Model model,
              @RequestParam(required = false) String q,
              @RequestParam(required = false) String sortCol,
              @RequestParam(required = false) String sortOrder)
{
    System.out.println("hello");
    System.out.println("q=" + q);
    System.out.println("sortCol=" + sortCol);
    System.out.println("sortOrder=" + sortOrder);
    List<Dog> list = dogService.serachAndSort(q,sortCol,sortOrder);
    model.addAttribute("dogs",list);
    model.addAttribute("key",q);
    return "/admin/dogs/list";
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
