package alla.verkhohliadova.demo_car.controller.excluded;

import alla.verkhohliadova.demo_car.dto.request.UserRequest;
import alla.verkhohliadova.demo_car.dto.response.UserResponse;
import alla.verkhohliadova.demo_car.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/post")
    public void create(@RequestBody UserRequest userRequest) {
        userService.register(userRequest);
    }

    @GetMapping("/get")
    public List<UserResponse> findAll() {
        return userService.findAll();
    }

    /*@DeleteMapping("/delete")
    public void delete(@RequestParam(value = "id") Long id)  {
        userService.delete(id);
    }*/

    /*@RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("user") User user,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("username", user.getUsername());
        model.addAttribute("password", user.getPassword());
        //model.addAttribute("id", employee.getId());
        return "userView";
    }*/




}
