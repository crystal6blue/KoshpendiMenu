package com.project.koshpendimenu1.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuDto {
    private String name;
    private String description;
    private int price;
    private Long categoryId;
    private String imageUrl;
}
