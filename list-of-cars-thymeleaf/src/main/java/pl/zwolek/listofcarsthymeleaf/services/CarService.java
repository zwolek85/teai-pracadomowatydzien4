package pl.zwolek.listofcarsthymeleaf.services;

import pl.zwolek.listofcarsthymeleaf.models.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<Car> getCars();

    Optional<Car> getCarById(long id);

    boolean addCar(Car car);

    boolean removeCar(Car car);

    void updateCar(final Car patchToCar);
}
