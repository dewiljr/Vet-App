package dev.patika.vet.api;

import dev.patika.vet.business.abstracts.ICustomerService;
import dev.patika.vet.dao.CustomerRepo;
import dev.patika.vet.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class CustomerController {

    @Autowired
    private final ICustomerService customerService;
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> findAll() {
        return  this.customerService.findAll();
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer save(@RequestBody Customer customer) {
        return this.customerService.save(customer);
    }

    @PutMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer update(@PathVariable Long id, @RequestBody Customer customer) {
        return this.customerService.update(id,customer);
    }
    @DeleteMapping("/customers/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.customerService.delete(id);
    }

    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getById(@PathVariable("id") Long id) {
        return this.customerService.getById(id);
    }

    @GetMapping("/customers/name")
    public ResponseEntity<List<Customer>> getCustomerByName(@RequestParam String name) {
        return new ResponseEntity<List<Customer>>(customerRepo.findByName(name),HttpStatus.OK);
    }
}
