package dev.patika.vet.dao;

import dev.patika.vet.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {
}
