package com.lego.care4you.web;

import com.lego.care4you.domain.SafetyEquipment;
import com.lego.care4you.dto.SafetyEquipmentRequestDTO;
import com.lego.care4you.service.SafetyEquipmentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ricardo.veizaga
 */
@RestController
@RequestMapping("/safetyEquipments")
@Api(value = "safetyEquipments", description = "Operations related to safetyEquipments")
public class SafetyEquipmentController {

    @Autowired
    private SafetyEquipmentService safetyEquipmentService;

    @RequestMapping(method = RequestMethod.GET)
    public List<SafetyEquipment> getSellers() {
        return safetyEquipmentService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public SafetyEquipment addSeller(@RequestBody SafetyEquipmentRequestDTO workDTO) {
        return safetyEquipmentService.insert(workDTO);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public SafetyEquipment deleteSeller(@PathVariable String id) {
        return safetyEquipmentService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public SafetyEquipment updateSeller(@PathVariable String id, @RequestBody SafetyEquipmentRequestDTO workRequestDTO) {
        return safetyEquipmentService.update(id, workRequestDTO);
    }
}
