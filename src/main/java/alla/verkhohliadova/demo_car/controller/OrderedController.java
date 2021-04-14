package alla.verkhohliadova.demo_car.controller;

import alla.verkhohliadova.demo_car.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordered")
public class OrderedController {

    @Autowired
    private OrderService orderService;
}
