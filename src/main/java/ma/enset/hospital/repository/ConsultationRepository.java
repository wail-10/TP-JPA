package ma.enset.hospital.repository;

import ma.enset.hospital.entities.Consultation;
import ma.enset.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    List<Consultation> findByDateConsultation(Date dateConsultation);
}
