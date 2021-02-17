package com.example.demo.services;

import com.example.demo.mocks.Address;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {

    public Address createAddress(Address address);

    public Address updateAddress(Address address);

    public Address getAddressById(long id);

    public void deleteAddress(long id);
}
