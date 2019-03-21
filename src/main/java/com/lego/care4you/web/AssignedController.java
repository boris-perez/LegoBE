package com.lego.care4you.web;

import com.lego.care4you.domain.Assigned;
import com.lego.care4you.dto.AssignedRequestDTO;
import com.lego.care4you.service.AssignedService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ricardo.veizaga
 */
@RestController
@RequestMapping("/assigneds")
@Api(value = "assigneds", description = "Operations related to assigneds")
public class AssignedController {

    @Autowired
    private AssignedService assignedService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Assigned> getSellers() {
        return assignedService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Assigned addSeller(@RequestBody AssignedRequestDTO assignedRequestDTO) {
        return assignedService.insert(assignedRequestDTO);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Assigned deleteSeller(@PathVariable String id) {
        return assignedService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Assigned updateSeller(@PathVariable String id, @RequestBody AssignedRequestDTO assignedRequestDTO) {
        return assignedService.update(id, assignedRequestDTO);
    }
}
