package dev.patika.vet.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "available_dates")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "available_id")
    private Long id;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "available_date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "available_doctor_id", referencedColumnName = "doctorId")
    private Doctor doctor;
}