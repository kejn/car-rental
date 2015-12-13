package pl.wroc.edu.jpa.dao;

import java.math.BigDecimal;
import java.util.List;

import pl.wroc.edu.model.entity.AllCars;

public interface CarDao extends Dao<AllCars, BigDecimal> {
	
	List<AllCars> findByParameters(String manufacturer, String location);

}
