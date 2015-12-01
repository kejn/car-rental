package pl.wroc.edu.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.wroc.edu.jpa.dao.CarDao;
import pl.wroc.edu.jpa.mapper.CarMapper;
import pl.wroc.edu.jpa.service.CarService;
import pl.wroc.edu.model.to.CarTo;

@Service
@Transactional(readOnly = true)
public class CarServiceImpl implements CarService {

	@Autowired
	private CarDao carDao;

	@Override
	public List<CarTo> findAllCars() {
		return CarMapper.map2To(carDao.findAll());
	}

	@Override
	public List<CarTo> findCarsByParameters(String manufacturer, String location) {
		return CarMapper.map2To(carDao.findByParameters(manufacturer, location));
	}

}
