package com.lego.care4you.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ricardo.veizaga
 */
@Getter
@Setter
public class CompanyRequestDTO {

    private String code;
    private String name;
    private String instructor;
    private String departmentId;

}
