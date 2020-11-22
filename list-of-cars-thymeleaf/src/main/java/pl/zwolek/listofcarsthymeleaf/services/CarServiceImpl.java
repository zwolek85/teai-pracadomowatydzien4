package pl.zwolek.listofcarsthymeleaf.services;

import org.springframework.stereotype.Service;
import pl.zwolek.listofcarsthymeleaf.models.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
class CarServiceImpl implements CarService {
    private List<Car> cars;

    CarServiceImpl() {
        cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        cars.sort(Comparator.comparing(Car::getId));
        return cars;
    }

    public Optional<Car> getCarById(long id) {
        return cars.stream().filter(car -> car.getId() == id).findFirst();
    }

    Optional<Car> getCarByColor(String color) {
        return cars.stream().filter(car -> car.getColor().equals(color)).findFirst();
    }

    @Override
    public boolean addCar(Car car) {
        return cars.add(car);
    }

    @Override
    public boolean removeCar(Car car) {
        return cars.remove(car);
    }

    @Override
    public void updateCar(final Car patchToCar) {
        Optional<Car> carById = getCarById(patchToCar.getId());
        carById.ifPresent(car -> {
            cars.remove(car);
            cars.add(patchToCar);
        });
    }
}
