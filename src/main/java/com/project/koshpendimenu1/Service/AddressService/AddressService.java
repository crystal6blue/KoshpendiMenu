package com.project.koshpendimenu1.Service.AddressService;

import com.project.koshpendimenu1.Model.Address;
import com.project.koshpendimenu1.Repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService implements IAddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    // Add a new address
    @Override
    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    // Update an existing address
    @Override
    public Address updateAddress(Long id, Address updatedAddress) {
        if (addressRepository.existsById(id)) {
            updatedAddress.setId(id); // Ensure the ID is set for the update
            return addressRepository.save(updatedAddress);
        }
        return null; // or throw an exception if the address does not exist
    }

    // Delete an address by ID
    @Override
    public void deleteAddress(Long id) {
        if (addressRepository.existsById(id)) {
            addressRepository.deleteById(id);
        }
    }

    // Fetch an address by ID
    @Override
    public Optional<Address> getAddressById(Long id) {
        return addressRepository.findById(id);
    }

    // Fetch all addresses
    @Override
    public Iterable<Address> getAllAddresses() {
        return addressRepository.findAll();
    }
}
