package com.lego.care4you.web;


import com.lego.care4you.domain.Buyer;
import com.lego.care4you.service.BuyerService;
import io.swagger.annotations.Api;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Alan.
 */
@RestController
@RequestMapping("/buyers")
@Api(value = "buyers", description = "Operations related to buyers")
public class BuyerController {


    private BuyerService buyerService;


    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Buyer> getBuyers() {
        return buyerService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Buyer addBuyer(@RequestBody BuyerRequestDTO buyerDTO) {
        return buyerService.insert(buyerDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Buyer deleteBuyer(@PathVariable String id) {
        return buyerService.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Buyer updateBuyer(@PathVariable String id, @RequestBody BuyerRequestDTO buyerDTO) {
        return buyerService.update(id, buyerDTO);
    }

    @Getter
    @Setter
    public static class BuyerRequestDTO {
        private String name;
        private String ci;
        private String profession;
        private long cellphone;
    }
}
