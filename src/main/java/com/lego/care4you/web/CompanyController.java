package com.lego.care4you.web;

import com.lego.care4you.domain.Company;
import com.lego.care4you.dto.CompanyRequestDTO;
import com.lego.care4you.service.CompanyService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ricardo.veizaga
 */
@RestController
@RequestMapping("/companies")
@Api(value = "companies", description = "Operations related to companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Company> getSellers() {
        return companyService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Company addSeller(@RequestBody CompanyRequestDTO companyRequestDTO) {
        return companyService.insert(companyRequestDTO);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Company deleteSeller(@PathVariable String id) {
        return companyService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Company updateSeller(@PathVariable String id, @RequestBody CompanyRequestDTO companyRequestDTO) {
        return companyService.update(id, companyRequestDTO);
    }
}
