package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarsService;
import web.service.CarsServiceImp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HelloController {

    @Autowired
    private CarsService carsService;

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "index";
    }

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(value = "count", required = false, defaultValue = "0") int count,
                            ModelMap model) {
        List<Car> cars = carsService.getCars();

        if (count <= cars.size() && count > -1) {
            ArrayList<Car> countedCars = cars.stream()
                    .limit(count)
                    .collect(Collectors.toCollection(ArrayList::new));
            model.addAttribute("cars", countedCars);
        } else {
            model.addAttribute("cars", cars);
        }
        return "cars";
    }
}