package com.haziq.crbs.modules.accounts.generic;

import com.haziq.crbs.modules.accounts.customer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<Customer> findByUsername(String username);

    Optional<Customer> findByEmail(String email);

    Boolean existsByEmail(String email);
}
