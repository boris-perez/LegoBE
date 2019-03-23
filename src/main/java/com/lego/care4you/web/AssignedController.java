package com.lego.care4you.web;

import com.lego.care4you.domain.Assigned;
import com.lego.care4you.dto.AssignedRequestDTO;
import com.lego.care4you.service.AssignedService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ricardo.veizaga
 */
@RestController
@RequestMapping("/assigneds")
@Api(value = "assigneds", description = "Operations related to assigneds")
public class AssignedController {


    private AssignedService assignedService;

    public AssignedController(AssignedService assignedService) {
        this.assignedService = assignedService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Assigned> findAll() {
        return assignedService.findAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public Assigned findById(@PathVariable String id) {
        return assignedService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Assigned insert(@RequestBody AssignedRequestDTO assignedRequestDTO) {
        return assignedService.insert(assignedRequestDTO);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Assigned delete(@PathVariable String id) {
        return assignedService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Assigned update(@PathVariable String id, @RequestBody AssignedRequestDTO assignedRequestDTO) {
        return assignedService.update(id, assignedRequestDTO);
    }
}