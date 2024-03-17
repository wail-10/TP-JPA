package ma.enset.hospital.service;

import ma.enset.hospital.entities.Consultation;
import ma.enset.hospital.entities.Medecin;
import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.entities.RendezVous;

import java.util.Date;
import java.util.List;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

    List<Patient> findAllPatients();
    List<Medecin> findAllMedecins();
    List<RendezVous> findAllRDVs();
    List<Consultation> findAllConsultations();

    Patient findPatientById(Long id);
    Medecin findMedecinById(Long id);
    RendezVous findRDVById(Long id);
    Consultation findConsultationById(Long id);

    List<Patient> searchPatient(String kw);
    List<Medecin> searchMedecin(String kw);
    List<RendezVous> searchRDV(String kw);
    List<Consultation> searchConsultation(Date date);

    Patient updatePatient(Long id, Patient patient);
    Medecin updateMedecin(Long id, Medecin medecin);
    RendezVous updateRDV(Long id, RendezVous rendezVous);
    Consultation updateConsultation(Long id, Consultation consultation);

    void deletePatient(Long id);
    void deleteMedecin(Long id);
    void deleteRendezVous(Long id);
    void deleteConsultation(Long id);
}
