package com.lego.care4you.service;

import com.lego.care4you.domain.Department;
import com.lego.care4you.dto.DepartmentRequestDTO;
import com.lego.care4you.repository.DepartmentRepository;
import com.lego.care4you.service.bootstrap.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ricardo.veizaga
 */
@Service
public class DepartmentService extends GenericService<Department, DepartmentRequestDTO> {

    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(String id) {
        return departmentRepository.findOne(id);
    }

    @Override
    public Department delete(String id) {
        Department department = findById(id);
        departmentRepository.delete(department);
        return department;
    }

    @Override
    public Department insert(DepartmentRequestDTO dto) {
        Department department = buildCreateDepartment(dto);
        department = departmentRepository.insert(department);
        return department;
    }

    @Override
    public Department update(String id, DepartmentRequestDTO dto) {
        Department department = findById(id);
        buildUpdateDepartment(department, dto);
        department = departmentRepository.insert(department);
        return department;
    }

    private Department buildCreateDepartment(DepartmentRequestDTO dto) {
        Department department = new Department();
        department.setName(dto.getName());
        department.setCode(dto.getCode());

        return department;
    }

    private void buildUpdateDepartment(Department department, DepartmentRequestDTO dto) {
        department.setName(dto.getName());
        department.setCode(dto.getCode());
    }
}
