package dev.patika.vet.dao;

import dev.patika.vet.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    List<Customer> findByName(String name);
}
