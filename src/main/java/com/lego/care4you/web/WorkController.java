package com.lego.care4you.web;

import com.lego.care4you.domain.Work;
import com.lego.care4you.service.WorkService;
import io.swagger.annotations.Api;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author rveizaga
 */
@RestController
@RequestMapping("/works")
@Api(value = "works", description = "Operations related to works")
public class WorkController {

    @Autowired
    private WorkService workService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Work> getSellers() {
        return workService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Work addSeller(@RequestBody WorkRequestDTO workDTO) {
        return workService.insert(workDTO);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Work deleteSeller(@PathVariable String id) {
        return workService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Work updateSeller(@PathVariable String id, @RequestBody WorkRequestDTO workRequestDTO) {
        return workService.update(id, workRequestDTO);
    }


    @Getter
    @Setter
    public static class WorkRequestDTO {
        private String workAmount;
        private String workCode;
        private String paymentType;
        private String positionId;
        private String employeeId;
    }
}

