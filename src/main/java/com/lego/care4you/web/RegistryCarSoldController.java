package com.lego.care4you.web;

import com.lego.care4you.domain.RegistryCarSold;
import com.lego.care4you.service.RegistryCarSoldService;
import io.swagger.annotations.Api;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Alan.
 */
@RestController
@RequestMapping("/registries")
@Api(value = "registries", description = "Operations related to transactions")
public class RegistryCarSoldController {

    @Autowired
    private RegistryCarSoldService registryCarSoldService;

    @RequestMapping(method = RequestMethod.GET)
    public List<RegistryCarSold> getRegistries() {
        return registryCarSoldService.findAll();
    }

    @RequestMapping(value = "/carsSoldBySeller/{sellerId}", method = RequestMethod.GET)
    public HashMap<String, Object> getRegistriesBySeller(@PathVariable String sellerId) {
        return registryCarSoldService.getRegistriesBySeller(sellerId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public RegistryCarSold addCar(@RequestBody RegistryCarSoldRequestDTO registryDTO) {
        return registryCarSoldService.insert(registryDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public RegistryCarSold deleteRegistry(@PathVariable String id) {
        return registryCarSoldService.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public RegistryCarSold updateRegistry(@PathVariable String id, @RequestBody RegistryCarSoldRequestDTO registryDTO) {
        return registryCarSoldService.update(id, registryDTO);
    }

    @Getter
    @Setter
    public static class RegistryCarSoldRequestDTO {
        private Date sellDate;
        private String sellerId;
        private String buyerId;
        private String carId;
    }
}
