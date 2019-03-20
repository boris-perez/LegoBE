package com.lego.care4you.web;


import com.lego.care4you.domain.Seller;
import com.lego.care4you.service.SellerService;
import io.swagger.annotations.Api;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Alan.
 */
@RestController
@RequestMapping("/sellers")
@Api(value = "sellers", description = "Operations related to sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Seller> getSellers() {
        return sellerService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Seller addSeller(@RequestBody SellerRequestDTO sellerDTO) {
        return sellerService.insert(sellerDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Seller deleteSeller(@PathVariable String id) {
        return sellerService.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Seller updateSeller(@PathVariable String id, @RequestBody SellerRequestDTO sellerDTO) {
        return sellerService.update(id, sellerDTO);
    }

    @Getter
    @Setter
    public static class SellerRequestDTO {
        private String name;
        private long age;
        private long ci;
        private long numCarsSold;
    }
}
