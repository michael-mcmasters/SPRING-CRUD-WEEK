package com.example.demo.repositories;

import com.example.demo.mocks.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepo extends CrudRepository<Address, Long> {
}
