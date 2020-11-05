package alla.verkhohliadova.demo_car.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class UserRequest {
    @NotBlank
    private String username;
    @Size(min = 3, max = 30)
    private String password;

//    @NotEmpty//@Size(min = 1)
    private List<Long> favoritesIds;
}
