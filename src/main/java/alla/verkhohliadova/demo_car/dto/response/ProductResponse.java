package alla.verkhohliadova.demo_car.dto.response;

import lombok.Getter;
import lombok.Setter;
import alla.verkhohliadova.demo_car.entity.Product;

@Getter
@Setter
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private Long price;
    private String image;
    private CategoryResponse category;

    public ProductResponse(Product product) {
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
        image = product.getImage();
        category = new CategoryResponse(product.getCategory());
    }
}
