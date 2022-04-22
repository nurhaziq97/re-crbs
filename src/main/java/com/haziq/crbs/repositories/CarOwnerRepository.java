package com.haziq.crbs.repositories;

import com.haziq.crbs.models.CarOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarOwnerRepository extends JpaRepository<CarOwner, Long> {
    Optional<CarOwner> findByUsername(String ownerName);

}