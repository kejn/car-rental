package pl.wroc.edu.jpa.service;

import java.math.BigDecimal;
import java.util.List;

import pl.wroc.edu.model.to.CarTo;

public interface CarService {
	
	List<CarTo> findAllCars();
	List<CarTo> findCarsByParameters(String manufacturer, String location);
	CarTo findCarById(BigDecimal id);
}
