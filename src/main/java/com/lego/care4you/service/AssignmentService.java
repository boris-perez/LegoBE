package com.lego.care4you.service;

import com.lego.care4you.domain.Assignment;
import com.lego.care4you.dto.AssignmentRequestDTO;
import com.lego.care4you.repository.*;
import com.lego.care4you.service.bootstrap.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ricardo.veizaga
 */
@Service
public class AssignmentService extends GenericService<Assignment, AssignmentRequestDTO> {

    private AssignmentRepository assignmentRepository;

    private DepartmentRepository departmentRepository;

    private EmployeeRepository employeeRepository;

    private SafetyEquipmentRepository safetyEquipmentRepository;

    private OrganizationChartRepository organizationChartRepository;

    public AssignmentService(AssignmentRepository assignmentRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, SafetyEquipmentRepository safetyEquipmentRepository, OrganizationChartRepository organizationChartRepository) {
        this.assignmentRepository = assignmentRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.safetyEquipmentRepository = safetyEquipmentRepository;
        this.organizationChartRepository = organizationChartRepository;
    }

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
        setAssignmentInformation(dto, assignment);

        return assignment;
    }

    private void buildUpdateAssignment(Assignment assignment, AssignmentRequestDTO dto) {
        setAssignmentInformation(dto, assignment);
    }

    private void setAssignmentInformation(AssignmentRequestDTO dto, Assignment assignment) {
        assignment.setDepartment(departmentRepository.findOne(dto.getDepartmentId()));
        assignment.setEmployee(employeeRepository.findOne(dto.getEmployeeId()));
        assignment.setSafetyEquipment(safetyEquipmentRepository.findOne(dto.getSafetyEquipmentId()));
        assignment.setOrganizationChart(organizationChartRepository.findOne(dto.getOrganizationChartId()));
    }
}
