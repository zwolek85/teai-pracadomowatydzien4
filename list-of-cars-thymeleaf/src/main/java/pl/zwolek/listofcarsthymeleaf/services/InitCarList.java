package pl.zwolek.listofcarsthymeleaf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.zwolek.listofcarsthymeleaf.models.Car;

import static pl.zwolek.listofcarsthymeleaf.enums.Color.*;

@Service
class InitCarList {

    private CarService carServiceImpl;

    @Autowired
    InitCarList(CarServiceImpl carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }

    @EventListener(ApplicationReadyEvent.class)
    void initCarList() {
        carServiceImpl.addCar(new Car(1, "Audi", "A6", BLACK));
        carServiceImpl.addCar(new Car(2, "Toyota", "Auris", RED));
        carServiceImpl.addCar(new Car(3, "Opel", "Astra", GREEN));
    }
}
