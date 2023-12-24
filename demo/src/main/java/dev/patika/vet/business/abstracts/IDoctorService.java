package dev.patika.vet.business.abstracts;

import dev.patika.vet.entities.Doctor;
import java.util.List;

public interface IDoctorService {
    Doctor getById(Long id);

    Doctor save(Doctor doctor);

    Doctor update(Long id,Doctor doctor);

    void delete(Long id);

    List<Doctor> findAll();
}
