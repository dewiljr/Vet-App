package dev.patika.vet.business.concretes;

import dev.patika.vet.business.abstracts.IAvailableDateService;
import dev.patika.vet.dao.AvailableDateRepo;
import dev.patika.vet.entities.AvailableDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvailableDateManager implements IAvailableDateService {

    @Autowired
    private AvailableDateRepo availableDateRepo;
    @Override
    public AvailableDate getById(Long id) {
        return this.availableDateRepo.findById(id).orElseThrow(() ->
                new RuntimeException(id + " Doktorun müsait gübü bulunamadı."));
    }
    @Override
    public AvailableDate save(AvailableDate availableDate) {
        return this.availableDateRepo.save(availableDate);
    }
    @Override
    public AvailableDate update(Long id, AvailableDate availableDate) {
        Optional<AvailableDate> availableDateFromDb = availableDateRepo.findById(id);

        if(availableDateFromDb.isEmpty()) {
            throw new RuntimeException(id +"Güncellemeye çalıştığınız doktorun müsait günü bulunamadı!");
        }
        availableDate.setId(id);
        return this.availableDateRepo.save(availableDate);
    }
    @Override
    public void delete(Long id) {
        AvailableDate av = availableDateRepo.findById(id).orElseThrow(() ->
                new RuntimeException(id + " Doktora ait uygun gün sistemde bulunamadı."));
        this.availableDateRepo.delete(this.getById(id));
    }
    @Override
    public List<AvailableDate> findAll() {
        return this.availableDateRepo.findAll();
    }
}
