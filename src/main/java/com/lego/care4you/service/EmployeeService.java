package com.lego.care4you.service;

import com.lego.care4you.domain.Employee;
import com.lego.care4you.repository.EmployeeRepository;
import com.lego.care4you.service.bootstrap.GenericService;
import com.lego.care4you.web.EmployeeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rveizaga
 */
@Service
public class EmployeeService extends GenericService<Employee, EmployeeController.EmployeeRequestDTO> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(String id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public Employee delete(String id) {
        Employee employee = findById(id);

        employeeRepository.delete(employee);

        return employee;
    }

    @Override
    public Employee insert(EmployeeController.EmployeeRequestDTO dto) {
        Employee employee = buildCreateEmployee(dto);

        employeeRepository.insert(employee);

        return employee;
    }

    @Override
    public Employee update(String id, EmployeeController.EmployeeRequestDTO dto) {
        Employee employee = findById(id);

        buildUpdateEmployee(employee, dto);
        employeeRepository.insert(employee);

        return employee;
    }

    private Employee buildCreateEmployee(EmployeeController.EmployeeRequestDTO dto) {
        Employee employee = new Employee();

        employee.setDni(dto.getDni());
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setAddress(dto.getAddress());
        employee.setEmail(dto.getEmail());
        employee.setPhone(dto.getPhone());
        employee.setJobDescription(dto.getJobDescription());

        return employee;
    }

    private void buildUpdateEmployee(Employee employee, EmployeeController.EmployeeRequestDTO dto) {

        employee.setDni(dto.getDni());
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setAddress(dto.getAddress());
        employee.setEmail(dto.getEmail());
        employee.setPhone(dto.getPhone());
        employee.setJobDescription(dto.getJobDescription());
    }
}
