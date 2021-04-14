package alla.verkhohliadova.demo_car.controller;

import alla.verkhohliadova.demo_car.dto.request.CategoryRequest;
import alla.verkhohliadova.demo_car.dto.response.CategoryResponse;
import alla.verkhohliadova.demo_car.service.CategoryService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/post")
    public void create(@RequestBody CategoryRequest categoryRequest){
       categoryService.create(categoryRequest);
    }

    @GetMapping("/get")
    public List<CategoryResponse> findAll() {
        return categoryService.findAll();
    }

    @PutMapping
    public void update (Long id, @RequestBody CategoryRequest categoryRequest){
        categoryService.update(id, categoryRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(Long id) throws NotFoundException {
        categoryService.delete(id);
    }
}
