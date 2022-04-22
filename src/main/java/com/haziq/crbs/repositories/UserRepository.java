package com.haziq.crbs.repositories;

import com.haziq.crbs.models.Customer;
import com.haziq.crbs.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<Customer> findByUsername(String username);

    Optional<Customer> findByEmail(String email);

    Boolean existsByEmail(String email);
}
