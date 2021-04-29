package alla.verkhohliadova.demo_car.controller;

import alla.verkhohliadova.demo_car.dto.request.UserRequest;
import alla.verkhohliadova.demo_car.dto.response.AuthenticationResponse;
import alla.verkhohliadova.demo_car.entity.User;
import alla.verkhohliadova.demo_car.entity.UserRole;
import alla.verkhohliadova.demo_car.repository.UserRepository;
import alla.verkhohliadova.demo_car.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class _UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AdminController adminController;

    @PostMapping("/registered")
    //public String create(@RequestBody UserRequest userRequest) {
    public ModelAndView create(UserRequest userRequest) throws Exception{
        userService.register(userRequest);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("html/registered");
        return modelAndView;
    }


   @PostMapping("/in")
   public ModelAndView log(UserRequest userRequest) {
       UserRole userRole = userService.findUserRoleByUsername(userRequest);
       ModelAndView modelAndView = new ModelAndView();
       try {
           userService.login(userRequest);
           if (userRole == UserRole.ROLE_ADMIN) {
               //return adminController.admin();
               modelAndView.setViewName("html/loginAdmin");
           }
           else{
               modelAndView.setViewName("html/logining");
           }
           return modelAndView;
       }catch (Exception e){
           modelAndView.setViewName("html/error");
           return modelAndView;
       }
    }

    @GetMapping("/list")
    public Iterable<User> getCustomers() {
        return userRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public User findCustomerById(@PathVariable Long id) {
        return userRepository.findUserById(id);
    }



    /*@RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView showForm(){
        return new ModelAndView("userHome", "user", new User());
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("user") User user,
                         BindingResult result, ModelMap model){
        if(result.hasErrors()){
            return "error";
        }
        model.addAttribute(("username"), user.getUsername());
        model.addAttribute(("password"), user.getPassword());
        return "userView";
    }*/
}
