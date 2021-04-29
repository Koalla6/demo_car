package alla.verkhohliadova.demo_car.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

@Entity
//@Table (name = "_order")
public class Ordered {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate date;

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    //private LocalTime time;

    private Boolean finished;

    @ManyToOne
    private User user;

    //@OneToMany(mappedBy = "ordered")
    //private List<ProductCount> productCounts = new ArrayList<>();

}
