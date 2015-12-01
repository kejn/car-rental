package pl.wroc.edu.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.wroc.edu.jpa.dao.BookingDao;
import pl.wroc.edu.jpa.mapper.BookingMapper;
import pl.wroc.edu.jpa.service.BookingService;
import pl.wroc.edu.model.entity.BookingEntity;
import pl.wroc.edu.model.to.BookingTo;

@Service
@Transactional(readOnly = true)
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDao bookingDao;
	
	@Override
	@Transactional(readOnly = false)
	public BookingTo saveBooking(BookingTo booking) {
		BookingEntity bookingEntity = BookingMapper.map(booking);
		return BookingMapper.map(bookingDao.save(bookingEntity));
	}

}
