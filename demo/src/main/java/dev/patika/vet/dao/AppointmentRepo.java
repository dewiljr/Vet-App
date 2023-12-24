package dev.patika.vet.dao;

import dev.patika.vet.entities.Animal;
import dev.patika.vet.entities.Appointment;
import dev.patika.vet.entities.Doctor;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDateTimeBetweenAndAnimalId(LocalDateTime startDate, LocalDateTime endDate, Integer animalId);
    List<Appointment> findByDateTimeBetweenAndDoctorId(LocalDateTime startDate, LocalDateTime endDate, Integer doctorId);
    boolean existsByDoctorIdAndDateTime(Integer doctorId, LocalDateTime dateTime);
}
