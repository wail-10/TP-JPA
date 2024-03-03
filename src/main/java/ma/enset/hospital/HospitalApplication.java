package ma.enset.hospital;

import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class HospitalApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        patientRepository.save(new Patient(null, "Ahmed", new Date("10/10/2002"),false, 8));
//        patientRepository.save(new Patient(null, "Wail", new Date("27/10/2002"),false, 10));
//        patientRepository.save(new Patient(null, "Oussama", new Date("20/10/2002"),false, 10));
        List<Patient> patients = patientRepository.findAll();
        patients.forEach(p->{
            System.out.println(p.toString());
        });
        System.out.println("*****************");
        Patient patient = patientRepository.findById(Long.valueOf(1)).get();
        System.out.println(patient.toString());
        System.out.println("*****************");
        List<Patient> patientList = patientRepository.findByNomContains("Wail");
        patientList.forEach(p->{
            System.out.println(p.toString());
        });
        System.out.println("*****************");
        // Mettre à jour un patient
        Patient patient1 = patientRepository.findById(Long.valueOf(2)).get();
        patient1.setMalade(true);
        patient1.setScore(5);
        patientRepository.save(patient1);
        System.out.println(patient1.toString());
        System.out.println("*****************");
        // Supprimer un patient
        patientRepository.deleteById(Long.valueOf(3));
    }
}
