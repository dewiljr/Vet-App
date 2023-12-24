package dev.patika.vet.dao;

import dev.patika.vet.entities.AvailableDate;
import dev.patika.vet.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AvailableDateRepo extends JpaRepository<AvailableDate, Long> {
    List<AvailableDate>  findByDoctorIdAndDate(Integer doctorId, LocalDate date);
    boolean existsByDoctorIdAndDate(Integer doctorId, LocalDate date);
}
