package com.haziq.crbs.modules.accounts.admin.repositories;

import com.haziq.crbs.modules.accounts.customer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public Optional<Customer> findById(Long id);
    Optional<Customer> findByUsername(String username);
    Boolean existsByEmail(String email);
}
