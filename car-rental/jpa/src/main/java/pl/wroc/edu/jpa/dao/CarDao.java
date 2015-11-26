package pl.wroc.edu.jpa.dao;

import java.math.BigDecimal;
import java.util.List;

import pl.wroc.edu.model.entity.CarEntity;

public interface CarDao extends Dao<CarEntity, BigDecimal> {
	
	List<CarEntity> findByParameters(String manufacturer, String location);

}
