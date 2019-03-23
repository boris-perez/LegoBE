package com.lego.care4you.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author alain.quinones
 */
@Getter
@Setter
public class EmployeeRequestDTO {

    private String dni;
    private String firstName;
    private String lastName;
    private String address;
    private long phone;
    private String email;
    private String jobDescription;
}