package ma.enset.hospital.repository;

import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
    List<RendezVous> findByStatus(String kw);
}
