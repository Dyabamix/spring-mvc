package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.service.CarServiceImp;

import java.util.List;

@Controller
public class CarController {

    private CarServiceImp carServiceImp;

    public CarController(CarServiceImp carServiceImp) {
        this.carServiceImp = carServiceImp;
    }

    @GetMapping(value = "/cars")
    public String printListCars(@RequestParam(value = "count", required = false) Integer count,
                                ModelMap model) {
        List<Car> cars = carServiceImp.getListCar(count);

        model.addAttribute("cars", cars);
        return "Cars";
    }
}
