package alla.verkhohliadova.demo_car.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private String keyWord;

    @GetMapping("**/homePageForAdmin/")
    public ModelAndView admin(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("html/homePageForAdmin");
        return modelAndView;
    }

    @PostMapping("/in/")
    public ModelAndView log(String key_word) {
        //UserRole userRole = userService.findUserRoleByUsername(userRequest);
        ModelAndView modelAndView = new ModelAndView();
        keyWord = "secret";
        try {
            if (key_word==keyWord){
                System.out.println(key_word);
                modelAndView.setViewName("html/homePageForAdmin");
                return modelAndView;
                //return admin();
            }
            else {
                System.out.println(key_word + "\t" + keyWord);
                modelAndView.setViewName("html/error");
                return modelAndView;
            }
        }catch (Exception e){
            modelAndView.setViewName("html/error");
            return modelAndView;
        }
    }
}
