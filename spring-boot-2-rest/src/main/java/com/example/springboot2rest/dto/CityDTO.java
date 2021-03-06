package com.example.springboot2rest.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CityDTO {

    @NotNull
    private Integer cod;

    @NotNull
    @Size(min = 3, max = 100)
    private String name;

    @NotNull
    @Size(min = 2, max = 2)
    private String state;

}
