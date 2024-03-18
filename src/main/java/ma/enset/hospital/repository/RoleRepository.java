package ma.enset.hospital.repository;

import ma.enset.hospital.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
