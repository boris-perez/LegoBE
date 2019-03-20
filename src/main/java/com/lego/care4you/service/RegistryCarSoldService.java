package com.lego.care4you.service;

import com.lego.care4you.domain.Buyer;
import com.lego.care4you.domain.Car;
import com.lego.care4you.domain.RegistryCarSold;
import com.lego.care4you.domain.Seller;
import com.lego.care4you.repository.BuyerRepository;
import com.lego.care4you.repository.CarRepository;
import com.lego.care4you.repository.RegistryCarSoldRepository;
import com.lego.care4you.repository.SellerRepository;
import com.lego.care4you.web.RegistryCarSoldController;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Alan.
 */
@Service
public class RegistryCarSoldService extends GenericService<RegistryCarSold, RegistryCarSoldController.RegistryCarSoldRequestDTO> {


    private RegistryCarSoldRepository registryCarSoldRepository;

    private SellerRepository sellerRepository;

    private BuyerRepository buyerRepository;

    private CarRepository carRepository;

    public RegistryCarSoldService(RegistryCarSoldRepository registryCarSoldRepository, SellerRepository sellerRepository, BuyerRepository buyerRepository, CarRepository carRepository) {
        this.registryCarSoldRepository = registryCarSoldRepository;
        this.sellerRepository = sellerRepository;
        this.buyerRepository = buyerRepository;
        this.carRepository = carRepository;
    }

    @Override
    public List<RegistryCarSold> findAll() {
        return registryCarSoldRepository.findAll();
    }

    @Override
    public RegistryCarSold findById(String id) {
        return registryCarSoldRepository.findOne(id);
    }

    @Override
    public RegistryCarSold delete(String id) {
        RegistryCarSold registryCarSold = registryCarSoldRepository.findOne(id);

        registryCarSoldRepository.delete(registryCarSold);

        return registryCarSold;
    }

    @Override
    public RegistryCarSold insert(RegistryCarSoldController.RegistryCarSoldRequestDTO dto) {
        Seller seller = sellerRepository.findOne(dto.getSellerId());
        Buyer buyer = buyerRepository.findOne(dto.getBuyerId());
        Car car = carRepository.findOne(dto.getCarId());

        RegistryCarSold registryCarSold = createRegistryCarSold(dto, seller, buyer, car);

        registryCarSoldRepository.save(registryCarSold);

        updateSellerCounter(seller);

        return registryCarSold;
    }

    @Override
    public RegistryCarSold update(String id, RegistryCarSoldController.RegistryCarSoldRequestDTO dto) {
        Seller seller = sellerRepository.findOne(dto.getSellerId());
        Buyer buyer = buyerRepository.findOne(dto.getBuyerId());
        Car car = carRepository.findOne(dto.getCarId());

        RegistryCarSold registryCarSold = createRegistryCarSold(dto, seller, buyer, car);
        registryCarSold.setId(id);

        registryCarSoldRepository.save(registryCarSold);

        return registryCarSold;
    }

    public HashMap<String, Object> getRegistriesBySeller(String sellerId) {
        HashMap<String, Object> response = new HashMap<String, Object>();
        RegistryCarSold registry = registryCarSoldRepository.findRegistriesBySeller(sellerId);

        if (null != registry) {
            response.put("name", registry.getSeller().getName());
            response.put("ci", registry.getSeller().getCi());
            response.put("CarsSoldNumber", registry.getSeller().getNumCarsSold());
        }
        return response;
    }

    private void updateSellerCounter(Seller seller) {
        long soldNumber = seller.getNumCarsSold() + 1;
        seller.setNumCarsSold(soldNumber);
        sellerRepository.save(seller);
    }

    private static RegistryCarSold createRegistryCarSold(RegistryCarSoldController.RegistryCarSoldRequestDTO dto, Seller seller, Buyer buyer, Car car) {
        RegistryCarSold registryCarSold = new RegistryCarSold();
        registryCarSold.setSellDate(dto.getSellDate());
        registryCarSold.setBuyer(buyer);
        registryCarSold.setSeller(seller);
        registryCarSold.setCar(car);
        return registryCarSold;
    }

}
