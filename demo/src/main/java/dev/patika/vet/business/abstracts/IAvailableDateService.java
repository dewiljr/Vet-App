package dev.patika.vet.business.abstracts;

import dev.patika.vet.dao.AvailableDateRepo;
import dev.patika.vet.entities.AvailableDate;

import java.util.List;

public interface IAvailableDateService {

    AvailableDate getById(Long id);

    AvailableDate save(AvailableDate availableDate);

    AvailableDate update(Long id,AvailableDate availableDate);

    void delete(Long id);

    List<AvailableDate> findAll();
}
