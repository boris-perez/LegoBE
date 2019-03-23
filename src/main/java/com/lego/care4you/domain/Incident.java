package com.lego.care4you.domain;

import com.lego.care4you.domain.bootstrap.GenericDomain;
import com.lego.care4you.domain.enums.IncidentType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author rveizaga
 */

@Getter
@Setter
@Document
public class Incident extends GenericDomain {

    private String incidentName;
    private String incidentCode;
    private IncidentType incidentType;
    private String incidentScope;
    private String incidentObjective;
    private String incidentCriteria;
    private String incidentPeriodicity;

    @DBRef
    private Employee employee;
}
