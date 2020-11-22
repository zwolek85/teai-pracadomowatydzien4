package pl.zwolek.listofcarsthymeleaf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.zwolek.listofcarsthymeleaf.models.Car;
import pl.zwolek.listofcarsthymeleaf.services.CarService;

import java.util.List;
import java.util.Optional;

@Controller
class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getCar(Model model) {
        model.addAttribute("cars", carService.getCars());
        return "cars";
    }

    @GetMapping("/add-car-view")
    public String addCarView(Model model) {
        model.addAttribute("newCar", new Car());
        return "addCar";
    }

    @PostMapping("/add-car")
    public String addCar(@ModelAttribute Car car) {
        List<Car> cars = carService.getCars();
        car.setId(cars.size() + 1);
        cars.add(car);
        return "redirect:/cars";
    }

    @GetMapping("/delete-car/{id}")
    public String deleteCar(@PathVariable long id) {
        Optional<Car> toDelete = carService.getCars().stream().filter(car -> id == car.getId()).findFirst();
        if (toDelete.isPresent()) {
            Car carToDelete = toDelete.get();
            carService.getCars().remove(carToDelete);
        }
        return "redirect:/cars";
    }

    @GetMapping("/update-view/{id}")
    public String updateViewCar(@PathVariable long id, Model model) {
        Optional<Car> toUpdate = carService.getCars().stream().filter(car -> id == car.getId()).findFirst();
        if (toUpdate.isPresent()) {
            Car carToUpdate = toUpdate.get();
            model.addAttribute("carToUpdate", carToUpdate);
        }
        return "carToUpdate";
    }

    @PostMapping("/update-car")
    public String updateCar(@ModelAttribute Car car) {
        List<Car> cars = carService.getCars();
        Optional<Car> toDelete = cars.stream().filter(c -> car.getId() == c.getId()).findFirst();
        if (toDelete.isPresent()) {
            Car carToDelete = toDelete.get();
            cars.remove(carToDelete);
        }
        cars.add(car);
        return "redirect:/cars";
    }

    @GetMapping("/details-car-view/{id}")
    public String detailsCarView(@PathVariable long id, Model model) {
        Optional<Car> details = carService.getCars().stream().filter(car -> id == car.getId()).findFirst();
        if (details.isPresent()) {
            Car carDetails = details.get();
            model.addAttribute("carDetails", carDetails);
        }
        return "detailsCar";
    }

    @PostMapping("/details-car-add-description/{id}")
    public String detailsCarAddDescription(@PathVariable long id, String description) {
        Optional<Car> details = carService.getCars().stream().filter(car -> id == car.getId()).findFirst();
        if (details.isPresent()) {
            Car carDetails = details.get();
            carDetails.setDescription(description);
        }
        return "redirect:/cars";
    }
}
