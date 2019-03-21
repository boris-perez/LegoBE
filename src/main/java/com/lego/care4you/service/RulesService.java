package com.lego.care4you.service;

import com.lego.care4you.domain.Rules;
import com.lego.care4you.dto.RulesRequestDTO;
import com.lego.care4you.repository.CompanyRepository;
import com.lego.care4you.repository.RulesRepository;
import com.lego.care4you.service.bootstrap.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ricardo.veizaga
 */
@Service
public class RulesService extends GenericService<Rules, RulesRequestDTO> {

    @Autowired
    private RulesRepository rulesRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Rules> findAll() {
        return rulesRepository.findAll();
    }

    @Override
    public Rules findById(String id) {
        return rulesRepository.findOne(id);
    }

    @Override
    public Rules delete(String id) {
        Rules rules = findById(id);
        rulesRepository.delete(rules);
        return rules;
    }

    @Override
    public Rules insert(RulesRequestDTO dto) {
        Rules rules = buildCreateRules(dto);
        rules = rulesRepository.insert(rules);

        return rules;
    }

    @Override
    public Rules update(String id, RulesRequestDTO dto) {
        Rules rules = findById(id);
        buildUpdateRules(rules, dto);
        rulesRepository.insert(rules);

        return rules;
    }

    private Rules buildCreateRules(RulesRequestDTO dto) {
        Rules rules = new Rules();
        rules.setState(dto.getState());
        rules.setCompany(companyRepository.findOne(dto.getCompanyId()));

        return rules;
    }

    private void buildUpdateRules(Rules rules, RulesRequestDTO dto) {
        rules.setState(dto.getState());
        rules.setCompany(companyRepository.findOne(dto.getCompanyId()));
    }
}
