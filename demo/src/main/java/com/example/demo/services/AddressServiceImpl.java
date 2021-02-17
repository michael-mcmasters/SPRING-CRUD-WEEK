package com.example.demo.services;

import com.example.demo.mocks.Address;
import com.example.demo.repositories.AddressRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    private AddressRepo addressRepo;


    @Override
    public Address createAddress(Address address) {
        return addressRepo.save(address);
    }

    @Override
    public Address updateAddress(Address address) {
        Optional<Address> optional = this.addressRepo.findById(address.getId());
        if (optional.isPresent()) {
            Address updatedAddress = optional.get();
            updatedAddress.setStreet(address.getStreet());
            updatedAddress.setNumber(address.getNumber());
            updatedAddress.setState(address.getState());
            addressRepo.save(updatedAddress);
        } else {
            // throw exception
        }
        return null;
    }

    @Override
    public Address getAddressById(long id) {
        Optional<Address> optional = addressRepo.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        // throw exception
        return null;
    }

    @Override
    public void deleteAddress(long id) {
        Address address = getAddressById(id);
        addressRepo.delete(address);
    }
}
