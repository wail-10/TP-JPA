package ma.enset.hospital.repository;

import ma.enset.hospital.entities.Medecin;
import ma.enset.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    List<Medecin> findByNomContains(String kw);
    Medecin findByNom(String nom);
}
