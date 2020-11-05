package alla.verkhohliadova.demo_car.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import alla.verkhohliadova.demo_car.dto.request.PaginationRequest;
import alla.verkhohliadova.demo_car.dto.request.ProductCriteria;
import alla.verkhohliadova.demo_car.dto.request.ProductRequest;
import alla.verkhohliadova.demo_car.dto.response.PageResponse;
import alla.verkhohliadova.demo_car.dto.response.ProductResponse;
import alla.verkhohliadova.demo_car.entity.Category;
import alla.verkhohliadova.demo_car.entity.Product;
import alla.verkhohliadova.demo_car.repository.ProductRepository;
import alla.verkhohliadova.demo_car.specification.ProductSpecification;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductService {

    //private static Map<Integer, Product> allUsers;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private FileService fileService;

    /*public static void setAllUsers(Map<Integer, Product> allUsers) {
        ProductService.allUsers = allUsers;
    }*/

    public void create(ProductRequest request) throws IOException {
        productRepository.save(productRequestToProduct(null, request));
    }

    public List<ProductResponse> findAllByCriteria(ProductCriteria criteria) {
        return productRepository.findAll(
                new ProductSpecification(criteria), criteria.getPaginationRequest().toPageable()
        ).stream().map(ProductResponse::new).collect(Collectors.toList());
    }

    public PageResponse<ProductResponse> findPage(PaginationRequest paginationRequest) {
        Page<Product> page = productRepository.findAll(paginationRequest.toPageable());
        return new PageResponse<>(page.getTotalPages(),
                page.getTotalElements(),
                page.get().map(ProductResponse::new).collect(Collectors.toList()));

    }

    public void update(Long id, ProductRequest request) throws IOException {
        productRepository.save(productRequestToProduct(findOne(id), request));
    }

    private Product productRequestToProduct(Product product, ProductRequest request) throws IOException {
        if (product == null) {
            product = new Product();
        }
        if (request.getImage() != null && !request.getImage().isEmpty()) {
            String path = fileService.saveFile(request.getImage());
            product.setImage(path);
        }
        Category category =
                categoryService.findOne(request.getCategoryId());
        product.setCategory(category);
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        return product;
    }

    public Product findOne(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product with id " + id + " not exists"));
    }

    /*public static List<Product> getAllProducts(){
        return new ArrayList<>(allUsers.values());
    }*/
}
