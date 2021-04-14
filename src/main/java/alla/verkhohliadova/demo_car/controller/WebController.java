package alla.verkhohliadova.demo_car.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    @GetMapping("/signUp")
    public String newUser(){
        return "html/newUser";
    }

    @GetMapping("/login")
    public String login(){
        return "html/login";
    }

    @GetMapping("**/allUsers")
    public String getAllUsers() {
        return "html/allUsers";
    }
}
