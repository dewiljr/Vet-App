package dev.patika.vet.business.concretes;

import dev.patika.vet.business.abstracts.IVaccineService;
import dev.patika.vet.dao.AnimalRepo;
import dev.patika.vet.dao.VaccineRepo;
import dev.patika.vet.entities.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VaccineManager implements IVaccineService {

    @Autowired
    private VaccineRepo vaccineRepo;
    @Override
    public Vaccine getById(Long id) {
        return this.vaccineRepo.findById(id).orElseThrow(() ->
                new RuntimeException(id + " Aşı bulunamadı."));
    }
    @Override
    public Vaccine save(Vaccine vaccine) {
        String code = vaccine.getCode();
        Integer animalId = Math.toIntExact(vaccine.getAnimal().getId());
        LocalDate startDate = vaccine.getStartDate();
        List<Vaccine> vaccineList = vaccineRepo.findAllByAnimalIdAndCodeAndFinishDateAfter(animalId,code,startDate);

        if(!vaccineList.isEmpty()) {
            throw new RuntimeException("Aşı koruyuculuğu henüz bitmemiştir.");
        } else {
            return this.vaccineRepo.save(vaccine);
        }
    }
    @Override
    public Vaccine update(Long id,Vaccine vaccine) {
        Optional<Vaccine> vaccineFromDb = vaccineRepo.findById(id);

        if(vaccineFromDb.isEmpty()) {
            throw new RuntimeException(id + "Güncellemeye çalıştığınız aşı bulunamadı!");
        }
        vaccine.setId(id);
        return this.vaccineRepo.save(vaccine);
    }
    @Override
    public void delete(Long id) {
        Vaccine v = vaccineRepo.findById(id).orElseThrow(() ->
                new RuntimeException(id + " Aşı bulunamadı."));
        this.vaccineRepo.delete(this.getById(id));
    }
    @Override
    public List<Vaccine> findAll() {
        return this.vaccineRepo.findAll();
    }
}
