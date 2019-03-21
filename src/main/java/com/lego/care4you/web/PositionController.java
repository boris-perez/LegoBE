package com.lego.care4you.web;

import com.lego.care4you.domain.Position;
import com.lego.care4you.dto.PositionRequestDTO;
import com.lego.care4you.service.PositionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ricardo.veizaga
 */
@RestController
@RequestMapping("/positions")
@Api(value = "positions", description = "Operations related to positions")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Position> getSellers() {
        return positionService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Position addSeller(@RequestBody PositionRequestDTO workDTO) {
        return positionService.insert(workDTO);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Position deleteSeller(@PathVariable String id) {
        return positionService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Position updateSeller(@PathVariable String id, @RequestBody PositionRequestDTO workRequestDTO) {
        return positionService.update(id, workRequestDTO);
    }
}
