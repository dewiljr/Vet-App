package dev.patika.vet.api;

import dev.patika.vet.business.abstracts.IVaccineService;
import dev.patika.vet.dao.VaccineRepo;
import dev.patika.vet.entities.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class VaccineController {

    @Autowired
    private final IVaccineService vaccineService;
    @Autowired
    private VaccineRepo vaccineRepo;

    @Autowired
    public VaccineController(IVaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @GetMapping("/vaccines")
    @ResponseStatus(HttpStatus.OK)
    public List<Vaccine> findAll() {
        return this.vaccineService.findAll();
    }

    @PostMapping("/vaccines")
    @ResponseStatus(HttpStatus.CREATED)
    public Vaccine save(@RequestBody Vaccine vaccine) {
        return this.vaccineService.save(vaccine);
    }

    @PutMapping("/vaccines/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Vaccine update(@PathVariable Long id, @RequestBody Vaccine vaccine) {
        return this.vaccineService.update(id,vaccine);
    }

    @DeleteMapping("/vaccines/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.vaccineService.delete(id);
    }

    @GetMapping("/vaccines/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Vaccine getById(@PathVariable("id") Long id) {
        return this.vaccineService.getById(id);
    }
    @GetMapping("/vaccines/animalId")
    public ResponseEntity<List<Vaccine>> getVaccinesByAnimalId(@RequestParam Integer animalId) {
        return new ResponseEntity<List<Vaccine>>(vaccineRepo.findByAnimalId(animalId),HttpStatus.OK);
    }
    @GetMapping("/vaccines/finishDate")
    public ResponseEntity<List<Vaccine>> getVaccinesByFinishDate(@RequestParam LocalDate startDate, @RequestParam  LocalDate endDate) {
        return new ResponseEntity<List<Vaccine>>(vaccineRepo.findByFinishDateBetween(startDate, endDate),HttpStatus.OK);
    }
}
