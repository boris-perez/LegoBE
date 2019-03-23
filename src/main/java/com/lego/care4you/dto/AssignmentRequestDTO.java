package com.lego.care4you.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ricardo.veizaga
 */
@Getter
@Setter
public class AssignmentRequestDTO {

    private String organizationChartId;
    private String departmentId;
    private String positionId;

}
