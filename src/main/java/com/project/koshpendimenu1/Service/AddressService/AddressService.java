package com.project.koshpendimenu1.Service.AddressService;

import com.project.koshpendimenu1.Dto.AddressDto;
import com.project.koshpendimenu1.Model.Address;
import com.project.koshpendimenu1.Repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService implements IAddressService {

    private final AddressRepository addressRepository;

    @Override
    public AddressDto getAddressById(Long id) {
        return addressRepository.findById(id)
                .map(this::getAddressDto).orElse(null);
    }

    private AddressDto getAddressDto(Address address) {
        return AddressDto.builder()
                .city(address.getCity())
                .zip(address.getZip())
                .id(address.getId())
                .street(address.getStreet())
                .build();
    }
}
