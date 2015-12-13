package pl.wroc.edu.jpa.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.impl.JPAQuery;

import pl.wroc.edu.jpa.dao.CarDao;
import pl.wroc.edu.model.entity.AllCars;
import pl.wroc.edu.model.entity.QAllCars;
import pl.wroc.edu.model.helper.EmptyString;

@Repository
public class CarDaoImpl extends AbstractDao<AllCars, BigDecimal> implements CarDao {

	@Override
	public List<AllCars> findByParameters(String manufacturer, String location) {
		JPAQuery query = new JPAQuery(entityManager);
		QAllCars carEntity = QAllCars.allCars;
		BooleanBuilder builder = new BooleanBuilder();
		if(!EmptyString.nullOrEmpty(manufacturer)) {
			builder.and(carEntity.model.manufacturer.name.startsWithIgnoreCase(manufacturer));
		}
		if(!EmptyString.nullOrEmpty(location)) {
			builder.and(carEntity.location.city.startsWithIgnoreCase(location));
		}
		return query.from(carEntity).where(builder).list(carEntity);
	}

}
