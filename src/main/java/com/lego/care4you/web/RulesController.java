package com.lego.care4you.web;

import com.lego.care4you.domain.Rules;
import com.lego.care4you.dto.RulesRequestDTO;
import com.lego.care4you.service.RulesService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author rveizaga
 */
@RestController
@RequestMapping("/rules")
@Api(value = "rules", description = "Operations related to rules")
public class RulesController {

    private RulesService rulesService;

    public RulesController(RulesService rulesService) {
        this.rulesService = rulesService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Rules> findAll() {
        return rulesService.findAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public Rules findById(@PathVariable String id) {
        return rulesService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Rules insert(@RequestBody RulesRequestDTO dto) {
        return rulesService.insert(dto);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Rules delete(@PathVariable String id) {
        return rulesService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Rules update(@PathVariable String id, @RequestBody RulesRequestDTO dto) {
        return rulesService.update(id, dto);
    }
}
