package com.project.koshpendimenu1.Dto;

import lombok.Builder;

@Builder
public class AddressDto {

    private Long id;
    private String city;
    private String street;
    private String zip;
}
