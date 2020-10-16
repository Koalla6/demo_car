package alla.verkhohliadova.demo_car.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    @Column(nullable = false)
    private UserRole userRole;

    @OneToOne
    private Car car;

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    @ManyToMany
    private List<Product> favorites = new ArrayList<>();

}
