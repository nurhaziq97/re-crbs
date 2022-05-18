package com.haziq.crbs.modules.accounts.admin.repositories;

import com.haziq.crbs.common.GenericRepository;
import com.haziq.crbs.modules.accounts.admin.entities.Admin;
import com.haziq.crbs.modules.accounts.customer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends GenericRepository<Admin> {
    public Optional<Admin> findById(Long id);
    Optional<Customer> findByUsername(String username);
    Boolean existsByEmail(String email);
}
