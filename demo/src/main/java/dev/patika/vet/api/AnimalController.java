package dev.patika.vet.api;

import dev.patika.vet.business.abstracts.IAnimalService;
import dev.patika.vet.dao.AnimalRepo;
import dev.patika.vet.entities.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class AnimalController {
    @Autowired
    private final IAnimalService animalService;

    @Autowired
    private AnimalRepo animalRepo;

    @Autowired
    public AnimalController(IAnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/animals")
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> findAll() {
        return this.animalService.findAll();
    }

    @PostMapping("/animals")
    @ResponseStatus(HttpStatus.CREATED)
    public Animal save(@RequestBody Animal animal) {
        return this.animalService.save(animal);
    }

    @PutMapping("/animals/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Animal update(@PathVariable  Long id, @RequestBody Animal animal) {
        return this.animalService.update(id,animal);
    }

    @DeleteMapping("/animals/{id}")
    public void delete(@PathVariable("id")Long id) {
        this.animalService.delete(id);
    }

    @GetMapping("/animals/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Animal getById(@PathVariable("id") Long id) {
        return this.animalService.getById(id);
    }

    @GetMapping("/animals/name")
    public ResponseEntity<List<Animal>> getAnimalByName(@RequestParam String name) {
        return new ResponseEntity<List<Animal>>(animalRepo.findByName(name),HttpStatus.OK);
    }
    @GetMapping("/animals/customerId")
    public ResponseEntity<List<Animal>> getAnimalsByCustomerId(@RequestParam Integer customerId) {
        return new ResponseEntity<List<Animal>>(animalRepo.findByCustomerId(customerId),HttpStatus.OK);
    }
}