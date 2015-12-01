package pl.wroc.edu.jpa.dao.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import pl.wroc.edu.jpa.dao.BookingDao;
import pl.wroc.edu.model.entity.BookingEntity;

@Repository
public class BookingDaoImpl extends AbstractDao<BookingEntity, BigDecimal> implements BookingDao {
}
