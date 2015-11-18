package pl.wroc.edu.model.dao;

import java.math.BigDecimal;
import java.util.List;

import pl.wroc.edu.model.entity.CarEntity;

public interface CarDao extends Dao<CarEntity, BigDecimal> {
	
	List<CarEntity> findByLocation(String location);
	
	List<CarEntity> findByManufacturer(String manufacturer);

	List<CarEntity> findByModelName(String modelName);

}
