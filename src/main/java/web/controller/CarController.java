package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarsService;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    CarsService carsService;

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(value = "count", required = false, defaultValue = "0") int count,
                            Model model) {

        List<Car> cars = carsService.getCars(count);
        model.addAttribute("cars", cars);

        return "cars/cars";
    }
}