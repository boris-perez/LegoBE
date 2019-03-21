package com.lego.care4you.web;

import com.lego.care4you.domain.OrganizationChart;
import com.lego.care4you.dto.OrganizationChartRequestDTO;
import com.lego.care4you.dto.PositionRequestDTO;
import com.lego.care4you.service.OrganizationChartService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ricardo.veizaga
 */
@RestController
@RequestMapping("/organizationCharts")
@Api(value = "organizationCharts", description = "Operations related to organizationCharts")
public class OrganizationChartController {

    @Autowired
    private OrganizationChartService organizationChartService;

    @RequestMapping(method = RequestMethod.GET)
    public List<OrganizationChart> getSellers() {
        return organizationChartService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public OrganizationChart addSeller(@RequestBody OrganizationChartRequestDTO organizationChartRequestDTO) {
        return organizationChartService.insert(organizationChartRequestDTO);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public OrganizationChart deleteSeller(@PathVariable String id) {
        return organizationChartService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public OrganizationChart updateSeller(@PathVariable String id, @RequestBody OrganizationChartRequestDTO organizationChartRequestDTO) {
        return organizationChartService.update(id, organizationChartRequestDTO);
    }
}
