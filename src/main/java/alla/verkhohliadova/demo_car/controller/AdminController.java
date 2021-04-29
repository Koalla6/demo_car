package alla.verkhohliadova.demo_car.controller;

import alla.verkhohliadova.demo_car.dto.request.UserRequest;
import alla.verkhohliadova.demo_car.dto.response.CategoryResponse;
import alla.verkhohliadova.demo_car.entity.Product;
import alla.verkhohliadova.demo_car.entity.UserRole;
import alla.verkhohliadova.demo_car.service.CategoryService;
import alla.verkhohliadova.demo_car.service.ProductService;
import alla.verkhohliadova.demo_car.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    //private java.lang.String keyWord = "admin";

    @GetMapping("/homePageForAdmin")
    public ModelAndView admin(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("html/homePageForAdmin");
        return modelAndView;
    }

    @PostMapping("/in")
    //public ModelAndView log(String key_word) {
    public ModelAndView log(UserRequest userRequest) {
        UserRole userRole = userService.findUserRoleByUsername(userRequest);
        //String Email = userService.findEmailByUsername(userRequest);
        ModelAndView modelAndView = new ModelAndView();
        try {
            if (userRole != UserRole.ROLE_ADMIN){
                modelAndView.setViewName("html/error");
            }
            else {
                modelAndView.setViewName("html/homePageForAdmin");
            }
            return modelAndView;
        }catch (Exception e){
            modelAndView.setViewName("html/error");
            return modelAndView;
        }
    }

    @GetMapping("/allUsers/delete/{id}")
    public ModelAndView deleteUser(@PathVariable Long id)  {
        userService.delete(id);
        //System.out.println(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect: /allUsers");
        return modelAndView;
    }

    @GetMapping("/allCars/delete/{id}")
    public ModelAndView deleteCar(@PathVariable Long id) {
        productService.delete(id);
        //System.out.println(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect: /allCars");
        return  modelAndView;
    }

    @GetMapping(value = "/allCars/update/{id}")//, consumes = {"multipart/form-data"})
    public ModelAndView updateCar(@PathVariable("id") Long id){//, ProductRequest productRequest, @RequestParam("file") MultipartFile file) throws IOException {
        Product product = productService.findOne(id);
        List<CategoryResponse> allCategories = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("html/updateCar");
        modelAndView.addObject("product", product);
        modelAndView.addObject("allCategories", allCategories);

        return modelAndView;
    }

   // @GetMapping("/user/{id}")
   // public ModelAndView getUserForAdmin(@)
}
