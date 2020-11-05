package alla.verkhohliadova.demo_car;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import javax.annotation.PostConstruct;

@SpringBootApplication
public class DemoCarApplication {



    public static void main(String[] args) {
        System.out.println("start");
        SpringApplication.run(DemoCarApplication.class, args);
        System.out.println("end");
        System.out.println("finish");
        //System.out.println(Country.class);
    }

}
