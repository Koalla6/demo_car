package alla.verkhohliadova.demo_car.repository;


import alla.verkhohliadova.demo_car.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
