package com.lego.care4you.web;


import com.lego.care4you.domain.Car;
import com.lego.care4you.service.CarService;
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
@RequestMapping("/cars")
@Api(value = "cars", description = "Operations related to cars")
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Car> getCars() {
        return carService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Car addCar(@RequestBody CarRequestDTO carDTO) {
        return carService.insert(carDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Car deleteCar(@PathVariable String id) {
        return carService.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Car updateCar(@PathVariable String id, @RequestBody CarRequestDTO carDTO) {
        return carService.update(id, carDTO);
    }

    @Getter
    @Setter
    public static class CarRequestDTO {
        private String brand;
        private long year;
        private String model;
        private String color;
        private String imageUrl;
    }
}
