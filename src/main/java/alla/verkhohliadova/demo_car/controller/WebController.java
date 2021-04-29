package alla.verkhohliadova.demo_car.controller;

import alla.verkhohliadova.demo_car.dto.response.CategoryResponse;
import alla.verkhohliadova.demo_car.dto.response.ProductResponse;
import alla.verkhohliadova.demo_car.dto.response.UserResponse;
import alla.verkhohliadova.demo_car.entity.Product;
import alla.verkhohliadova.demo_car.service.CategoryService;
import alla.verkhohliadova.demo_car.service.ProductService;
import alla.verkhohliadova.demo_car.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//import java.util.Map;

@Controller
public class WebController {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/signUp")
    public String newUser(){
        return "html/newUser";
    }

    @GetMapping("/login")
    public String login(){
        return "html/login";
    }

    @GetMapping("/catalog")
    public ModelAndView catalog(){
        ModelAndView modelAndView = new ModelAndView();
        List<ProductResponse> allCars = productService.findAll();
        modelAndView.setViewName("html/catalog");
        modelAndView.addObject("allCars", allCars);
        return modelAndView;
    }

    @GetMapping("/catalog/car/{id}")
    public ModelAndView oneCar(@PathVariable("id") Long id){
        Product product = productService.findOne(id);
        List<CategoryResponse> allCategories = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("html/Car");
        modelAndView.addObject("product", product);
        modelAndView.addObject("allCategories", allCategories);
        return modelAndView;
    }

    @GetMapping("**/allUsers")
    public ModelAndView getAllUsers() {
        ModelAndView modelAndView = new ModelAndView();
        List<UserResponse> allUsers = userService.findAll();
        modelAndView.setViewName("html/allUsers");
        modelAndView.addObject("allUsers", allUsers);

        return modelAndView;
    }

    @GetMapping("**/allCars")
    public ModelAndView getAllCars() {
        ModelAndView modelAndView = new ModelAndView();
        List<ProductResponse> allCars = productService.findAll();
        modelAndView.setViewName("html/allCars");
        modelAndView.addObject("allCars", allCars);
        return modelAndView;
    }

    @GetMapping("**/add")
    public ModelAndView newCar(){
        List<CategoryResponse> allCategories = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("allCategories", allCategories);
        modelAndView.setViewName("html/newCar");
        return modelAndView;
    }


}
