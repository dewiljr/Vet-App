package dev.patika.vet.business.abstracts;

import dev.patika.vet.entities.Vaccine;

import java.time.LocalDate;
import java.util.List;

public interface IVaccineService {

    Vaccine getById(Long id);

    Vaccine save(Vaccine vaccine);

    Vaccine update(Long id,Vaccine vaccine);

    void delete(Long id);

    List<Vaccine> findAll();

}
