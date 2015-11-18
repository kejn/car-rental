package pl.wroc.edu.model.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public interface Dao<T, K extends Serializable> {

	T save(T entity);

	T getOne(K id);

	T findOne(K id);

	List<T> findAll();

	T update(T entity);

	void delete(T entity);

	void delete(K id);

	void deleteAll();

	BigDecimal count();

	boolean exists(K id);
}
