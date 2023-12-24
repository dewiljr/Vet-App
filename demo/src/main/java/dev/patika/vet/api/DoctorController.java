package dev.patika.vet.api;

import dev.patika.vet.business.abstracts.IDoctorService;
import dev.patika.vet.entities.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class DoctorController {

    @Autowired
    private IDoctorService doctorService;


    @GetMapping("/doctors")
    @ResponseStatus(HttpStatus.OK)
    public List<Doctor> findAll() {
        return this.doctorService.findAll();
    }

    @PostMapping("/doctors")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor save(@RequestBody Doctor doctor) {
        return this.doctorService.save(doctor);
    }

    @PutMapping("/doctors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Doctor update(@PathVariable Long id, @RequestBody Doctor doctor) {
        return this.doctorService.update(id,doctor);
    }

    @DeleteMapping("/doctors/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.doctorService.delete(id);
    }

    @GetMapping("/doctors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Doctor getById(@PathVariable("id") Long id) {
        return  this.doctorService.getById(id);
    }
}

