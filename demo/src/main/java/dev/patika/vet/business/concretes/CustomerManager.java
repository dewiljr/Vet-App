package dev.patika.vet.business.concretes;

import dev.patika.vet.business.abstracts.ICustomerService;
import dev.patika.vet.dao.CustomerRepo;
import dev.patika.vet.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerManager implements ICustomerService {

    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public Customer getById(Long id) {
        return this.customerRepo.findById(id).orElseThrow(() ->
                new RuntimeException(id + " Hayvan sahibi bulunamadı."));
    }
    @Override
    public Customer save(Customer customer) {
        return this.customerRepo.save(customer);
    }

    @Override
    public Customer update(Long id, Customer customer) {
        Optional<Customer> customerFromDb = customerRepo.findById(id);

        if(customerFromDb.isEmpty()) {
            throw new RuntimeException(id + "Güncellemeye çalıştığınız hayvan sahibi bulunamadı!");
        }
        customer.setId(id);
        return this.customerRepo.save(customer);
    }

    @Override
    public void delete(Long id) {
        Customer c = customerRepo.findById(id).orElseThrow(() ->
                new RuntimeException(id + " Hayvan sahibi bulunamadı!"));
        this.customerRepo.delete(this.getById(id));
    }

    @Override
    public List<Customer> findAll() {
        return this.customerRepo.findAll();
    }
}
