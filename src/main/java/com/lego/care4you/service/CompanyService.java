package com.lego.care4you.service;

import com.lego.care4you.domain.Company;
import com.lego.care4you.dto.CompanyRequestDTO;
import com.lego.care4you.repository.CompanyRepository;
import com.lego.care4you.service.bootstrap.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ricardo.veizaga
 */
@Service
public class CompanyService extends GenericService<Company, CompanyRequestDTO> {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findById(String id) {
        return companyRepository.findOne(id);
    }

    @Override
    public Company delete(String id) {
        Company company = findById(id);
        companyRepository.delete(company);
        return company;
    }

    @Override
    public Company insert(CompanyRequestDTO dto) {
        Company company = buildCreateCompany(dto);
        company = companyRepository.insert(company);
        return company;
    }

    @Override
    public Company update(String id, CompanyRequestDTO dto) {
        Company company = findById(id);
        buildUpdateCompany(company, dto);
        company = companyRepository.insert(company);
        return company;
    }

    private Company buildCreateCompany(CompanyRequestDTO dto) {
        Company company = new Company();
        company.setCode(dto.getCode());
        company.setName(dto.getName());
        company.setInstructor(dto.getInstructor());

        return company;
    }

    private void buildUpdateCompany(Company company, CompanyRequestDTO dto) {
        company.setCode(dto.getCode());
        company.setName(dto.getName());
        company.setInstructor(dto.getInstructor());
    }
}
