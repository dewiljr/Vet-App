package dev.patika.vet.business.abstracts;

import dev.patika.vet.entities.Animal;

import java.util.List;
import java.util.Optional;

public interface IAnimalService {
    Animal getById(Long id);

    Animal save(Animal animal);

    Animal update(Long id, Animal animal);

    void delete(Long id);

    List<Animal> findAll();
}
