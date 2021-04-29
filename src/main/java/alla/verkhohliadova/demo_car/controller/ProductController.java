package alla.verkhohliadova.demo_car.controller;

import alla.verkhohliadova.demo_car.dto.request.ProductRequest;
import alla.verkhohliadova.demo_car.service.CategoryService;
import alla.verkhohliadova.demo_car.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@RestController
@RequestMapping("**/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping(value = "/add", consumes = {"multipart/form-data"})
    public ModelAndView create(ProductRequest productRequest, @RequestParam("file") MultipartFile file) throws Exception{
        productService.create(productRequest, file);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("html/addedCar");
        return modelAndView;
    }

    @PostMapping(value = "/updated/{id}", consumes = {"multipart/form-data"})
    public ModelAndView update(@PathVariable("id") Long id, ProductRequest productRequest, @RequestParam("file") MultipartFile file) throws IOException {
        productService.update(id, productRequest, file);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("html/updatedCar");
        return modelAndView;
    }

}
