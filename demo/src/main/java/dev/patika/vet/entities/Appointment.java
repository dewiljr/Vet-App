package dev.patika.vet.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id", columnDefinition = "serial")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    @NotNull
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "appointment_animal_id", referencedColumnName = "animalId")
    private Animal animal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "appointment_doctor_id", referencedColumnName = "doctorId")
    private Doctor doctor;

}
