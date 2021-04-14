package alla.verkhohliadova.demo_car.repository;

import alla.verkhohliadova.demo_car.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername (String username);
    boolean existsByUsername(String username);
    User findUserById(Long id);
}
