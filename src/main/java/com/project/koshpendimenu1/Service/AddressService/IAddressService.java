package com.project.koshpendimenu1.Service.AddressService;

import com.project.koshpendimenu1.Model.Address;

import java.util.Optional;

public interface IAddressService {

    // Add a new address
    Address addAddress(Address address);

    // Update an existing address
    Address updateAddress(Long id, Address updatedAddress);

    // Delete an address by ID
    void deleteAddress(Long id);

    // Fetch an address by ID
    Optional<Address> getAddressById(Long id);

    // Fetch all addresses
    Iterable<Address> getAllAddresses();
}
