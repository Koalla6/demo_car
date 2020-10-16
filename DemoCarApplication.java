package alla.verkhohliadova.demo_car;

//import alla.verlhohliadova.demo_car.entity.Country;
//import alla.verlhohliadova.demo_car.repository.CountryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import javax.annotation.PostConstruct;

@SpringBootApplication
public class DemoCarApplication {

    /*@Autowired
    private CountryRepository countryRepository;

    @PostConstruct
    public void init(){
        Country country = new Country();
        country.setName("Germany");
        countryRepository.save(country);

    }*/

    public static void main(String[] args) {

        SpringApplication.run(DemoCarApplication.class, args);
        
        //System.out.println(Country.class);
    }

}
