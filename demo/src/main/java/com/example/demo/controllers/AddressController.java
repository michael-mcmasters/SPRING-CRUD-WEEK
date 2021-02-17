package com.example.demo.controllers;

import com.example.demo.mocks.Address;
import com.example.demo.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/address/[id]")
    public ResponseEntity<Address> getAddressById(@PathVariable long id) {
        return ResponseEntity.ok().body(addressService.getAddressById(id));
    }

    @PostMapping("/address")
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        return ResponseEntity.ok().body(addressService.createAddress(address));
    }

    @PutMapping("/address/[id]")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address address) {
        address.setId(id);
        return ResponseEntity.ok().body(addressService.updateAddress(address));
    }

    public HttpStatus deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        return HttpStatus.OK;
    }
}
