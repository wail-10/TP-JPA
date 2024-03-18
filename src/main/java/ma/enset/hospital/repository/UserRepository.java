package ma.enset.hospital.repository;

import ma.enset.hospital.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
