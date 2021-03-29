package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarsDaoImp implements CarsDao {

    @Override
    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Вольво", "Ржавый", 1996));
        cars.add(new Car("Жигуль", "Прозрачный", 1945));
        cars.add(new Car("Рено", "Желтый", 2011));
        cars.add(new Car("Фольксваген", "Белый", 2015));
        cars.add(new Car("Мерседес", "Черный", 2018));

        return cars;
    }
}