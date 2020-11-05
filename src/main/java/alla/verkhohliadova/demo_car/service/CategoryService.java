package alla.verkhohliadova.demo_car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import alla.verkhohliadova.demo_car.dto.request.CategoryRequest;
import alla.verkhohliadova.demo_car.dto.response.CategoryResponse;
import alla.verkhohliadova.demo_car.entity.Category;
import alla.verkhohliadova.demo_car.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void create(CategoryRequest request) {
        categoryRepository.save(categoryRequestToCategory(null, request));
    }

    public List<CategoryResponse> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryResponse::new)
                .collect(Collectors.toList());
    }

    public Category findOne(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category with id " + id + " not exists"));
    }

    public void update(Long id, CategoryRequest request) {
        categoryRepository.save(categoryRequestToCategory(findOne(id), request));
    }

    public void delete(Long id) {
        categoryRepository.delete(findOne(id));
    }


    private Category categoryRequestToCategory(Category category, CategoryRequest request) {
        if (category == null) {
            category = new Category();
        }
        category.setName(request.getName());
        return category;
    }
}

    /*private static Map<Long, Category> allNames;
    //private static int countId = 0;

    public static List<Category> getAllNames() {
        try {
            return new ArrayList<>(allNames.values());
        }catch (NullPointerException nullPointerException){
            System.out.println(nullPointerException);
        }
        return new ArrayList<>(allNames.values());
    }
}*/
