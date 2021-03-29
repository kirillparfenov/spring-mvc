package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarsDao;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarsServiceImp implements CarsService {

    @Autowired
    private CarsDao carsDao;

    @Override
    public List<Car> getCars(int count) {
        return carsDao.getCars().stream()
                    .limit(count)
                    .collect(Collectors.toCollection(ArrayList::new));
    }
}