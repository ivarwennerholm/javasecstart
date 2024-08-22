package se.systementor.javasecstart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.systementor.javasecstart.model.Dog;
import se.systementor.javasecstart.model.DogRepository;
import se.systementor.javasecstart.services.DogService;

import java.util.List;

@Controller
public class AdminDogController {
    @Autowired
    private DogRepository dogRepository;
    @Autowired
    private DogService dogService;

    /*
    @GetMapping(path="/admin/dogs")
    String list(Model model){
        model.addAttribute("activeFunction", "home");
//        setupVersion(model);

        model.addAttribute("dogs", dogService.getPublicDogs());
        return "admin/dogs/list";
    }

     */


/*//  only sorting -- Rasmus
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
    }*/

/*//    only searching -- Venus
    @GetMapping(path="/admin/dogs")
    String search(Model model,
                @RequestParam(defaultValue = "name") String sortCol,
                @RequestParam(defaultValue = "ASC") String sortOrder,
                @RequestParam(defaultValue = "") String q)
    {
        List<Dog> list = null;
        // Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortCol);
        if (q != null){
            list = dogService.getSearchDogList(q);
        } else {
            list =  dogService.getPublicDogs();
        }
        model.addAttribute("q", q);
        model.addAttribute("dogs", list);

        return "/admin/dogs/list";
    }*/

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

 /*   @GetMapping("/search")
    String search(Model model, @RequestParam(required = false) String keyword){

        List<Dog> searchDogs = dogService.getSearchDogs(keyword);
        model.addAttribute("searchDogs", searchDogs);

        return "/admin/dogs/list";
    }*/

}
