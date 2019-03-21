package com.lego.care4you.dto;

import com.lego.care4you.domain.enums.IncidentType;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ricardo.veizaga
 */
@Getter
@Setter
public class IncidentRequestDTO {

    private String incidentName;
    private String incidentCode;
    private IncidentType incidentType;
    private String incidentScope;
    private String incidentObjective;
    private String incidentCriteria;
    private String incidentPeriodicity;
    private String employeeId;
}
