package ma.enset.hospital;

import ma.enset.hospital.entities.*;
import ma.enset.hospital.repository.MedecinRepository;
import ma.enset.hospital.repository.PatientRepository;
import ma.enset.hospital.repository.RendezVousRepository;
import ma.enset.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication2.class, args);
    }

    @Bean
    CommandLineRunner start(
            IHospitalService hospitalService,
            PatientRepository patientRepository,
            MedecinRepository medecinRepository,
            RendezVousRepository rendezVousRepository){
        return args -> {
//            Stream.of("Mohamed", "Wail", "Ahmed")
//                    .forEach(name->{
//                        Patient patient = new Patient();
//                        patient.setNom(name);
//                        patient.setDateNaissance(new Date());
//                        patient.setMalade(false);
//                        patient.setScore(10);
//                        hospitalService.savePatient(patient);
//                    });
//
//            // medecins
//            Stream.of("Ali", "Oussama", "Houssam")
//                    .forEach(name->{
//                        Medecin medecin = new Medecin();
//                        medecin.setNom(name);
//                        medecin.setEmail(name+"@gmail.com");
//                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
//                        hospitalService.saveMedecin(medecin);
//                    });
//
//            Patient patient = patientRepository.findById(1L).orElse(null);
//            Patient patient1 = patientRepository.findByNom("Mohamed");
//
//            Medecin medecin = medecinRepository.findByNom("Houssam");
//
//            RendezVous rendezVous = new RendezVous();
//            rendezVous.setDate(new Date());
//            rendezVous.setStatus(StatusRDV.PENDING);
//            rendezVous.setPatient(patient);
//            rendezVous.setMedecin(medecin);
//            hospitalService.saveRDV(rendezVous);
//
//            RendezVous rendezVous1 = rendezVousRepository.findById(1L).orElse(null);
//            Consultation consultation = new Consultation();
//            consultation.setDateConsultation(new Date());
//            consultation.setRendezVous(rendezVous1);
//            consultation.setRapport("Rapport de la consultation......");
//            hospitalService.saveConsultation(consultation);
            Patient patient = new Patient();
            patient.setNom("Laila");
            hospitalService.updatePatient(1L, patient);
        };
    }
}
