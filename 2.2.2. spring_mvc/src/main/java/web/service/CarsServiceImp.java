package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarsDao;
import web.model.Car;

import java.util.List;

@Service
public class CarsServiceImp implements CarsService {

    @Autowired
    private CarsDao carsDao;

    @Override
    public List<Car> getCars() {
        return carsDao.getCars();
    }
}
