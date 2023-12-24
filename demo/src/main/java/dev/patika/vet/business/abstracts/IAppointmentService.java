package dev.patika.vet.business.abstracts;

import dev.patika.vet.entities.Animal;
import dev.patika.vet.entities.Appointment;
import dev.patika.vet.entities.AvailableDate;
import dev.patika.vet.entities.Doctor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IAppointmentService {
    Appointment getById(Long id);

    Appointment save(Appointment appointment);

    Appointment update(Long id,Appointment appointment);

    void delete(Long id);

    List<Appointment> findAll();
}
