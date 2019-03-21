package com.lego.care4you.web;

import com.lego.care4you.domain.Assignment;
import com.lego.care4you.dto.AssignmentRequestDTO;
import com.lego.care4you.service.AssignmentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ricardo.veizaga
 */
@RestController
@RequestMapping("/assignments")
@Api(value = "assignments", description = "Operations related to assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Assignment> getSellers() {
        return assignmentService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Assignment addSeller(@RequestBody AssignmentRequestDTO assignmentRequestDTO) {
        return assignmentService.insert(assignmentRequestDTO);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Assignment deleteSeller(@PathVariable String id) {
        return assignmentService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Assignment updateSeller(@PathVariable String id, @RequestBody AssignmentRequestDTO assignmentRequestDTO) {
        return assignmentService.update(id, assignmentRequestDTO);
    }
}
