package pl.wroc.edu.jpa.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import pl.wroc.edu.jpa.dao.CarDao;
import pl.wroc.edu.model.entity.CarEntity;

public class CarDaoImpl extends AbstractDao<CarEntity, BigDecimal> implements CarDao {

	@Override
	public List<CarEntity> findByLocation(String location) {
		return entityManager.createQuery(selectFromCarEntityEqual("location",location)).getResultList();
	}

	@Override
	public List<CarEntity> findByManufacturer(String manufacturer) {
		return entityManager.createQuery(selectFromCarEntityEqual("manufacturer",manufacturer)).getResultList();
	}

	@Override
	public List<CarEntity> findByModelName(String modelName) {
		return entityManager.createQuery(selectFromCarEntityEqual("model",modelName)).getResultList();
	}
	
	private CriteriaQuery<CarEntity> selectFromCarEntityEqual(String column, String value) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CarEntity> criteriaQuery = builder.createQuery(CarEntity.class);
		Root<CarEntity> root = criteriaQuery.from(CarEntity.class);
		criteriaQuery.select(root);
		criteriaQuery.where(builder.equal(root.get(column), value));
		return criteriaQuery;
	}
	
}
