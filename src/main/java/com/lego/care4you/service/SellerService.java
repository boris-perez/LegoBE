package com.lego.care4you.service;

import com.lego.care4you.domain.Seller;
import com.lego.care4you.repository.SellerRepository;
import com.lego.care4you.service.bootstrap.GenericService;
import com.lego.care4you.web.SellerController;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alan.
 */
@Service
public class SellerService extends GenericService<Seller, SellerController.SellerRequestDTO> {

    private SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public List<Seller> findAll() {
        return sellerRepository.findAll();
    }

    @Override
    public Seller findById(String id) {
        return sellerRepository.findOne(id);
    }

    @Override
    public Seller delete(String id) {
        Seller seller = sellerRepository.findOne(id);

        sellerRepository.delete(seller);

        return seller;
    }

    @Override
    public Seller insert(SellerController.SellerRequestDTO dto) {
        Seller seller = createSeller(dto);

        sellerRepository.save(seller);

        return seller;
    }

    @Override
    public Seller update(String id, SellerController.SellerRequestDTO dto) {
        // TODO: fix this implementation
        Seller seller = createSeller(dto);
        seller.setId(id);

        sellerRepository.save(seller);

        return seller;
    }

    private static Seller createSeller(SellerController.SellerRequestDTO dto) {
        Seller seller = new Seller();
        seller.setName(dto.getName());
        seller.setAge(dto.getAge());
        seller.setCi(dto.getCi());
        seller.setNumCarsSold(dto.getNumCarsSold());

        return seller;
    }
}
