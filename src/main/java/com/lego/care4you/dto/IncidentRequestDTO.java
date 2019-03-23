package com.lego.care4you.dto;

import com.lego.care4you.domain.enums.IncidentSeverity;
import com.lego.care4you.domain.enums.IncidentType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author ricardo.veizaga
 */
@Getter
@Setter
public class IncidentRequestDTO {

    private String name;
    private String description;
    private Date date;
    private IncidentType type;
    private IncidentSeverity severity;
    private String observation;

    private String employeeId;
}
