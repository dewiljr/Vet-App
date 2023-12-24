package dev.patika.vet.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "vaccines")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccineId", columnDefinition = "serial")
    private Long id;

    @Column(name = "vaccine_name",length = 250)
    private String name;

    @Column(name="vaccine_code",length = 250)
    private String code;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "startDate")
    private LocalDate startDate;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "finishDate")
    private LocalDate finishDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vaccineAnimalId", referencedColumnName = "animalId")
    private Animal animal;
}
