package dev.patika.vet.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "doctors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctorId", columnDefinition = "serial")
    private Long id;

    @Column(name = "doctor_name", length = 250)
    @NotNull
    private String name;

    @Column(name = "doctor_phone", length = 250)
    @NotNull
    private String phone;

    @Column(name = "doctor_mail", length = 250)
    private String mail;

    @Column(name = "doctor_address", length = 250)
    private String address;

    @Column(name = "doctor_city", length = 250)
    private String city;

    @OneToMany(mappedBy = "doctor",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Appointment> appointmentList;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<AvailableDate> availableDates;
}
