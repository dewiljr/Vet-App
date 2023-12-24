package dev.patika.vet.dao;

import dev.patika.vet.entities.Vaccine;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface VaccineRepo extends JpaRepository<Vaccine, Long> {
    List<Vaccine> findByAnimalId(Integer animalId);
    List<Vaccine> findByFinishDateBetween(LocalDate startDate, LocalDate endDate);
    List<Vaccine> findAllByAnimalIdAndCodeAndFinishDateAfter(Integer animalId,String code,LocalDate startDate);

}