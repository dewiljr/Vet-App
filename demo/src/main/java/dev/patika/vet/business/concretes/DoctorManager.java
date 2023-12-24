package dev.patika.vet.business.concretes;

import dev.patika.vet.business.abstracts.IDoctorService;
import dev.patika.vet.dao.DoctorRepo;
import dev.patika.vet.entities.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorManager implements IDoctorService {

    @Autowired
    private DoctorRepo doctorRepo;
    @Override
    public Doctor getById(Long id) {
        return this.doctorRepo.findById(id).orElseThrow(() ->
                new RuntimeException(id + " Doktor bulunamadı."));
    }
    @Override
    public Doctor save(Doctor doctor) {
        return this.doctorRepo.save(doctor);
    }
    @Override
    public Doctor update(Long id,Doctor doctor) {
        Optional<Doctor> doctorFromDb = doctorRepo.findById(id);

        if(doctorFromDb.isEmpty()) {
            throw new RuntimeException(id + "Güncellemeye çalıştığınız doktorun kaydı bulunmamaktadır!");
        }
        doctor.setId(id);
        return this.doctorRepo.save(doctor);
    }
    @Override
    public void delete(Long id) {
        Doctor d = doctorRepo.findById(id).orElseThrow(() ->
                new RuntimeException(id + " Doktor bulunamadı!"));
        this.doctorRepo.delete(this.getById(id));
    }
    @Override
    public List<Doctor> findAll() {
        return this.doctorRepo.findAll();
    }
}
