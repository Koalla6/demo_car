package alla.verkhohliadova.demo_car.entity;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long price;

    private String image;

    @Column(columnDefinition = "text")
    private String description;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<ProductCount> productCounts = new ArrayList<>();

    @ManyToMany(mappedBy = "favorites")
    private List<User> users = new ArrayList<>();



}
