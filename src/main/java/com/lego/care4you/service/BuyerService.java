package com.lego.care4you.service;


import com.lego.care4you.domain.Buyer;
import com.lego.care4you.repository.BuyerRepository;
import com.lego.care4you.service.bootstrap.GenericService;
import com.lego.care4you.web.BuyerController;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alan.
 */
@Service
public class BuyerService extends GenericService<Buyer, BuyerController.BuyerRequestDTO> {

    private BuyerRepository buyerRepository;

    public BuyerService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    @Override
    public List<Buyer> findAll() {
        return buyerRepository.findAll();
    }

    @Override
    public Buyer findById(String id) {
        return buyerRepository.findOne(id);
    }

    @Override
    public Buyer delete(String id) {
        Buyer buyer = buyerRepository.findOne(id);

        buyerRepository.delete(buyer);

        return buyer;
    }

    @Override
    public Buyer insert(BuyerController.BuyerRequestDTO dto) {
        Buyer buyer = createBuyer(dto);

        buyerRepository.save(buyer);

        return buyer;
    }

    @Override
    public Buyer update(String id, BuyerController.BuyerRequestDTO buyerRequestDTO) {
        Buyer buyer = buyerRepository.findOne(id);
        updateBuyer(buyer, buyerRequestDTO);

        buyerRepository.save(buyer);

        return buyer;
    }

    private static Buyer createBuyer(BuyerController.BuyerRequestDTO dto) {
        Buyer buyer = new Buyer();
        buyer.setName(dto.getName());
        buyer.setCellphone(dto.getCellphone());
        buyer.setCi(dto.getCi());
        buyer.setProfession(dto.getProfession());
        return buyer;
    }

    private static void updateBuyer(Buyer buyer, BuyerController.BuyerRequestDTO dto) {
        buyer.setName(dto.getName());
        buyer.setCellphone(dto.getCellphone());
        buyer.setCi(dto.getCi());
        buyer.setProfession(dto.getProfession());
    }
}
