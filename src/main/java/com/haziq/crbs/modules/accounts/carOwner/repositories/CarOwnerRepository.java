package com.haziq.crbs.modules.accounts.carOwner.repositories;

import com.haziq.crbs.common.GenericRepository;
import com.haziq.crbs.modules.accounts.carOwner.entities.CarOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarOwnerRepository extends GenericRepository<CarOwner> {

}