package pl.wroc.edu.jpa.service;

import java.util.List;

import pl.wroc.edu.model.to.CarTo;

public interface CarService {
	
	List<CarTo> findAllCars();

//	List<CarTo> findByLocation(String location);
//
//	List<CarTo> findByManufacturer(String manufacturer);
//
//	List<CarTo> findByModelName(String modelName);

}
