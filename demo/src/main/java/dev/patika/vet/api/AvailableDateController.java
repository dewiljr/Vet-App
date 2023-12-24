package dev.patika.vet.api;

import dev.patika.vet.business.abstracts.IAvailableDateService;
import dev.patika.vet.entities.AvailableDate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class AvailableDateController {

    @Autowired
    private final IAvailableDateService availableDateService;

    @Autowired
    public AvailableDateController(IAvailableDateService availableDateService) {
        this.availableDateService = availableDateService;
    }

    @GetMapping("/availabledates")
    @ResponseStatus(HttpStatus.OK)
    public List<AvailableDate> findAll() {
        return this.availableDateService.findAll();
    }

    @PostMapping("/availabledates")
    @ResponseStatus(HttpStatus.CREATED)
    public AvailableDate save(@RequestBody AvailableDate availableDate) {
        return this.availableDateService.save(availableDate);
    }

    @PutMapping("/availabledates/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AvailableDate update(@PathVariable Long id, @RequestBody AvailableDate availableDate) {
        return this.availableDateService.update(id,availableDate);
    }

    @DeleteMapping("/availabledates/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.availableDateService.delete(id);
    }

    @GetMapping("/availabledates/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AvailableDate getById(@PathVariable("id") Long id) {
        return this.availableDateService.getById(id);
    }
}
