package alla.verkhohliadova.demo_car.entity;


import lombok.*;

import javax.persistence.*;

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

    @Column//(nullable = false)
    private String model;

    @Column
    private TransmissionBox transmissionBox;

    @Column
    private Integer numberOfSeats;

    @Column
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
    private Integer yearOfIssue;

    @Column//(nullable = false)
    private Long pricePerDay;

    @Column
    private Integer numberOfDays;

    private String image;
    //private File file;

    @Column(columnDefinition = "text", nullable = false)
    private String description;

    @ManyToOne
    private Category category;

    //@OneToMany(mappedBy = "product")
    //private List<ProductCount> productCounts = new ArrayList<>();

    //@ManyToMany(mappedBy = "favorites")
    //private List<User> users = new ArrayList<>();

}
