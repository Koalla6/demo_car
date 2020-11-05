package alla.verkhohliadova.demo_car.dto.request;

import alla.verkhohliadova.demo_car.entity.Category;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class CategoryRequest {
    @NotBlank
    private String name;


}


