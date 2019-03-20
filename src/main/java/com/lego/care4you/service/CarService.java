package com.lego.care4you.service;


import com.lego.care4you.domain.Car;
import com.lego.care4you.repository.CarRepository;
import com.lego.care4you.web.CarController;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alan.
 */
@Service
public class CarService extends GenericService<Car, CarController.CarRequestDTO> {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Car findById(String id) {
        return carRepository.findOne(id);
    }

    @Override
    public Car delete(String id) {
        Car car = carRepository.findOne(id);

        carRepository.delete(car);

        return car;
    }

    @Override
    public Car insert(CarController.CarRequestDTO dto) {
        Car car = createCar(dto);

        carRepository.save(car);

        return car;
    }

    @Override
    public Car update(String id, CarController.CarRequestDTO dto) {
        Car car = createCar(dto);
        car.setId(id);

        carRepository.save(car);

        return car;
    }

    private static Car createCar(CarController.CarRequestDTO dto) {
        Car car = new Car();
        car.setBrand(dto.getBrand());
        car.setColor(dto.getColor());
        car.setImageUrl(dto.getImageUrl());
        car.setModel(dto.getModel());
        car.setYear(dto.getYear());
        return car;
    }
}
