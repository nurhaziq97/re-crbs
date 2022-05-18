package com.haziq.crbs.modules.accounts.customer.repositories;

import com.haziq.crbs.common.GenericRepository;
import com.haziq.crbs.modules.accounts.customer.entities.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends GenericRepository<Customer> {

}
