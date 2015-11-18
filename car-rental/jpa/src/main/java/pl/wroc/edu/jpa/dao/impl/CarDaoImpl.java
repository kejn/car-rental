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
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CarEntity> criteriaQuery = builder.createQuery(CarEntity.class);
		Root<CarEntity> root = criteriaQuery.from(CarEntity.class);
		criteriaQuery.select(root);
		criteriaQuery.where(builder.equal(root.get("location"), location));
		
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public List<CarEntity> findByManufacturer(String manufacturer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarEntity> findByModelName(String modelName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
