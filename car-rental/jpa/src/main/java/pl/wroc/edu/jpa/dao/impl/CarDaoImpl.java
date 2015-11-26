package pl.wroc.edu.jpa.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.impl.JPAQuery;

import pl.wroc.edu.jpa.dao.CarDao;
import pl.wroc.edu.model.entity.CarEntity;
import pl.wroc.edu.model.entity.QCarEntity;
import pl.wroc.edu.model.helper.EmptyString;

@Repository
public class CarDaoImpl extends AbstractDao<CarEntity, BigDecimal> implements CarDao {

	@Override
	public List<CarEntity> findByParameters(String manufacturer, String location) {
		if(EmptyString.nullOrEmpty(manufacturer) && EmptyString.nullOrEmpty(location)) {
			return super.findAll();
		}
		JPAQuery query = new JPAQuery(entityManager);
		QCarEntity carEntity = QCarEntity.carEntity;
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
