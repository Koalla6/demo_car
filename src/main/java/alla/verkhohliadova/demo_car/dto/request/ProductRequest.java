package alla.verkhohliadova.demo_car.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class ProductRequest {
    @NotBlank
    private String name;
    @Positive
    private Long price;
    private String description;
    private String image;
    @NotNull
    private Long categoryId;
}
