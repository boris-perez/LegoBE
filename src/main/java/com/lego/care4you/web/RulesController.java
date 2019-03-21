package com.lego.care4you.web;

import com.lego.care4you.domain.Rules;
import com.lego.care4you.dto.RulesRequestDTO;
import com.lego.care4you.service.RulesService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author rveizaga
 */
@RestController
@RequestMapping("/rules")
@Api(value = "rules", description = "Operations related to rules")
public class RulesController {

    @Autowired
    private RulesService rulesService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Rules> getSellers() {
        return rulesService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Rules addSeller(@RequestBody RulesRequestDTO workDTO) {
        return rulesService.insert(workDTO);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Rules deleteSeller(@PathVariable String id) {
        return rulesService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Rules updateSeller(@PathVariable String id, @RequestBody RulesRequestDTO workRequestDTO) {
        return rulesService.update(id, workRequestDTO);
    }
}
