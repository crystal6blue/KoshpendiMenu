package com.project.koshpendimenu1.Controller;

import com.project.koshpendimenu1.Model.Address;
import com.project.koshpendimenu1.Service.AddressService.IAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final IAddressService addressService;

    public AddressController(IAddressService addressService) {
        this.addressService = addressService;
    }

    // Create a new address
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Address addAddress(@RequestBody Address address) {
        return addressService.addAddress(address);
    }

    // Get an address by ID
    @GetMapping("/{id}")
    public Optional<Address> getAddressById(@PathVariable Long id) {
        return addressService.getAddressById(id);
    }

    // Get all addresses
    @GetMapping
    public Iterable<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    // Update an address
    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable Long id, @RequestBody Address updatedAddress) {
        return addressService.updateAddress(id, updatedAddress);
    }

    // Delete an address by ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
    }
}
