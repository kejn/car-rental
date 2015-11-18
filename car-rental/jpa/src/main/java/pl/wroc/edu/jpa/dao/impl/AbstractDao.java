package pl.wroc.edu.jpa.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import pl.wroc.edu.jpa.dao.Dao;

@Transactional(Transactional.TxType.REQUIRED)
public abstract class AbstractDao<T, K extends Serializable> implements Dao<T, K> {

	@PersistenceContext
	protected EntityManager entityManager;

	private Class<T> domainClass;

	@Override
	public T save(T entity) {
		entityManager.persist(entity);
		return entity;
	}

	@Override
	public T getOne(K id) {
		return entityManager.getReference(getDomainClass(), id);
	}

	@Override
	public T findOne(K id) {
		return entityManager.find(getDomainClass(), id);
	}

	@Override
	public List<T> findAll() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(getDomainClass());
		criteriaQuery.from(getDomainClass());
		TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public T update(T entity) {
		return entityManager.merge(entity);
	}

	@Override
	public void delete(T entity) {
		entityManager.remove(entity);
	}

	@Override
	public void delete(K id) {
		entityManager.remove(getOne(id));
	}

	@Override
	public void deleteAll() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaDelete<T> criteriaDelete = criteriaBuilder.createCriteriaDelete(getDomainClass());
		criteriaDelete.from(getDomainClass());
		entityManager.createQuery(criteriaDelete).executeUpdate();
	}

	@Override
	public BigDecimal count() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<T> root = countQuery.from(getDomainClass());
		countQuery.select(builder.count(root));
		return new BigDecimal(entityManager.createQuery(countQuery).getSingleResult());
	}

	@Override
	public boolean exists(K id) {
		return (findOne(id) != null);
	}

	@SuppressWarnings("unchecked")
	protected Class<T> getDomainClass() {
		if (domainClass == null) {
			ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
			domainClass = (Class<T>) type.getActualTypeArguments()[0];
		}
		return domainClass;
	}

	protected String getDomainClassName() {
		return getDomainClass().getName();
	}
}
