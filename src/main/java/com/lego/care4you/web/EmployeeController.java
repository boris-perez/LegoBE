package com.lego.care4you.web;

import com.lego.care4you.domain.Employee;
import com.lego.care4you.service.EmployeeService;
import io.swagger.annotations.Api;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author rveizaga
 */
@RestController
@RequestMapping("/employees")
@Api(value = "employees", description = "Operations related to employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> getSellers() {
        return employeeService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Employee addSeller(@RequestBody EmployeeRequestDTO workDTO) {
        return employeeService.insert(workDTO);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Employee deleteSeller(@PathVariable String id) {
        return employeeService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Employee updateSeller(@PathVariable String id, @RequestBody EmployeeRequestDTO workRequestDTO) {
        return employeeService.update(id, workRequestDTO);
    }

    @Getter
    @Setter
    public static class EmployeeRequestDTO {

        private String dni;
        private String firstName;
        private String lastName;
        private String address;
        private long phone;
        private String email;
        private String jobDescription;
    }
}
