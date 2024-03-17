package ma.enset.hospital.service;

import jakarta.transaction.Transactional;
import ma.enset.hospital.entities.*;
import ma.enset.hospital.repository.ConsultationRepository;
import ma.enset.hospital.repository.MedecinRepository;
import ma.enset.hospital.repository.PatientRepository;
import ma.enset.hospital.repository.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public List<Medecin> findAllMedecins() {
        return medecinRepository.findAll();
    }

    @Override
    public List<RendezVous> findAllRDVs() {
        return rendezVousRepository.findAll();
    }

    @Override
    public List<Consultation> findAllConsultations() {
        return consultationRepository.findAll();
    }

    @Override
    public Patient findPatientById(Long id) {
        return patientRepository.findById(id).get();
    }

    @Override
    public Medecin findMedecinById(Long id) {
        return medecinRepository.findById(id).get();
    }

    @Override
    public RendezVous findRDVById(Long id) {
        return rendezVousRepository.findById(id).get();
    }

    @Override
    public Consultation findConsultationById(Long id) {
        return consultationRepository.findById(id).get();
    }

    @Override
    public List<Patient> searchPatient(String kw) {
        return patientRepository.findByNomContains(kw);
    }

    @Override
    public List<Medecin> searchMedecin(String kw) {
        return medecinRepository.findByNomContains(kw);
    }

    @Override
    public List<RendezVous> searchRDV(String kw) {
        return rendezVousRepository.findByStatus(kw);
    }

    @Override
    public List<Consultation> searchConsultation(Date date) {
        return consultationRepository.findByDateConsultation(date);
    }

    @Override
    public Patient updatePatient(Long id, Patient updatedPatient) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            patient.setNom(updatedPatient.getNom());
            patient.setDateNaissance(updatedPatient.getDateNaissance());
            patient.setMalade(updatedPatient.isMalade());
            patient.setScore(updatedPatient.getScore());
            return patientRepository.save(patient);
        } else {
            System.out.println("Patient doesn't Exist");
            return null;
        }
    }

    @Override
    public Medecin updateMedecin(Long id, Medecin updatedMedecin) {
        Optional<Medecin> optionalMedecin = medecinRepository.findById(id);
        if (optionalMedecin.isPresent()) {
            Medecin medecin = optionalMedecin.get();
            medecin.setEmail(updatedMedecin.getNom());
            medecin.setEmail(updatedMedecin.getEmail());
            medecin.setSpecialite(updatedMedecin.getSpecialite());
            return medecinRepository.save(medecin);
        } else {
            System.out.println("Medecin doesn't Exist");
            return null;
        }
    }

    @Override
    public RendezVous updateRDV(Long id, RendezVous updatedRendezVous) {
        Optional<RendezVous> optionalRendezVous = rendezVousRepository.findById(id);
        if (optionalRendezVous.isPresent()) {
            RendezVous rendezVous = optionalRendezVous.get();
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setDate(new Date());
            return rendezVousRepository.save(rendezVous);
        } else {
            System.out.println("RendezVous doesn't Exist");
            return null;
        }
    }

    @Override
    public Consultation updateConsultation(Long id, Consultation updatedConsultation) {
        Optional<Consultation> optionalConsultation = consultationRepository.findById(id);
        if (optionalConsultation.isPresent()) {
            Consultation consultation = optionalConsultation.get();
            consultation.setRapport("Nouveau rapport ...");
            consultation.setDateConsultation(new Date());
            return consultationRepository.save(consultation);
        } else {
            System.out.println("Consultation doesn't Exist");
            return null;
        }
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public void deleteMedecin(Long id) {
        medecinRepository.deleteById(id);
    }

    @Override
    public void deleteRendezVous(Long id) {
        rendezVousRepository.deleteById(id);
    }

    @Override
    public void deleteConsultation(Long id) {
        consultationRepository.deleteById(id);
    }
}
