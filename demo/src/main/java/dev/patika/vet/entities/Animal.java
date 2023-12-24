package dev.patika.vet.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "animals")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animalId", columnDefinition = "serial")
    private Long id;

    @Column(name = "animal_name",length = 250)
    @NotNull
    private String name;

    @Column(name = "species", length = 250)
    @NotNull
    private String species;

    @Column(name = "breed", length = 250)
    @NotNull
    private String breed;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private GENDER gender;

    @Column(name = "colour", length = 250)
    private String colour;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "dateOfBirth")
    private LocalDate date;

    public enum GENDER  {
        MALE,
        FEMALE
    }

    @OneToMany(mappedBy = "animal", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Vaccine> vaccineList;

    @OneToMany(mappedBy = "animal", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Appointment> appointmentList;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animalCustomerId", referencedColumnName = "customerId")
    private Customer customer;
}