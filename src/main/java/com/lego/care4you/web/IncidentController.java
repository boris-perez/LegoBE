package com.lego.care4you.web;

import com.lego.care4you.domain.Incident;
import com.lego.care4you.dto.IncidentRequestDTO;
import com.lego.care4you.service.IncidentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ricardo.veizaga
 */
@RestController
@RequestMapping("/incidents")
@Api(value = "incidents", description = "Operations related to incidents")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Incident> getSellers() {
        return incidentService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Incident addSeller(@RequestBody IncidentRequestDTO incidentRequestDTO) {
        return incidentService.insert(incidentRequestDTO);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Incident deleteSeller(@PathVariable String id) {
        return incidentService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Incident updateSeller(@PathVariable String id, @RequestBody IncidentRequestDTO incidentRequestDTO) {
        return incidentService.update(id, incidentRequestDTO);
    }
}
