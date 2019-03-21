package com.lego.care4you.service;

import com.lego.care4you.domain.Assignment;
import com.lego.care4you.dto.AssignmentRequestDTO;
import com.lego.care4you.repository.*;
import com.lego.care4you.service.bootstrap.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ricardo.veizaga
 */
@Service
public class AssignmentService extends GenericService<Assignment, AssignmentRequestDTO> {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SafetyEquipmentRepository safetyEquipmentRepository;

    @Autowired
    private OrganizationChartRepository organizationChartRepository;

    @Override
    public List<Assignment> findAll() {
        return assignmentRepository.findAll();
    }

    @Override
    public Assignment findById(String id) {
        return assignmentRepository.findOne(id);
    }

    @Override
    public Assignment delete(String id) {
        Assignment assignment = findById(id);
        assignmentRepository.delete(assignment);
        return assignment;
    }

    @Override
    public Assignment insert(AssignmentRequestDTO dto) {
        Assignment assignment = buildCreateAssignment(dto);
        assignment = assignmentRepository.insert(assignment);
        return assignment;
    }

    @Override
    public Assignment update(String id, AssignmentRequestDTO dto) {
        Assignment assignment = findById(id);
        buildUpdateAssignment(assignment, dto);
        assignment = assignmentRepository.insert(assignment);
        return assignment;
    }

    private Assignment buildCreateAssignment(AssignmentRequestDTO dto) {
        Assignment assignment = new Assignment();
        assignment.setDepartment(departmentRepository.findOne(dto.getDepartmentId()));
        assignment.setEmployee(employeeRepository.findOne(dto.getEmployeeId()));
        assignment.setSafetyEquipment(safetyEquipmentRepository.findOne(dto.getSafetyEquipmentId()));
        assignment.setOrganizationChart(organizationChartRepository.findOne(dto.getOrganizationChartId()));

        return assignment;
    }

    private void buildUpdateAssignment(Assignment assignment, AssignmentRequestDTO dto) {
        assignment.setDepartment(departmentRepository.findOne(dto.getDepartmentId()));
        assignment.setEmployee(employeeRepository.findOne(dto.getEmployeeId()));
        assignment.setSafetyEquipment(safetyEquipmentRepository.findOne(dto.getSafetyEquipmentId()));
        assignment.setOrganizationChart(organizationChartRepository.findOne(dto.getOrganizationChartId()));
    }
}
