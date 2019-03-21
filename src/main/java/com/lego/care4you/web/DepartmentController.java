package com.lego.care4you.web;

import com.lego.care4you.domain.Department;
import com.lego.care4you.dto.DepartmentRequestDTO;
import com.lego.care4you.service.DepartmentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ricardo.veizaga
 */
@RestController
@RequestMapping("/departments")
@Api(value = "departments", description = "Operations related to departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Department> getSellers() {
        return departmentService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Department addSeller(@RequestBody DepartmentRequestDTO departmentRequestDTO) {
        return departmentService.insert(departmentRequestDTO);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Department deleteSeller(@PathVariable String id) {
        return departmentService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Department updateSeller(@PathVariable String id, @RequestBody DepartmentRequestDTO departmentRequestDTO) {
        return departmentService.update(id, departmentRequestDTO);
    }
}
