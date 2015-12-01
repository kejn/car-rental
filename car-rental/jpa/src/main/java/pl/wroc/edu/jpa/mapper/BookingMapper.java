package pl.wroc.edu.jpa.mapper;

import java.sql.Date;
import java.util.Calendar;

import pl.wroc.edu.model.entity.BookingEntity;
import pl.wroc.edu.model.to.BookingTo;

public class BookingMapper {

	public static BookingTo map(BookingEntity booking) {
		return new BookingTo(booking.getId(), CarMapper.map(booking.getCar()), RenterMapper.map(booking.getRenter()),
				date2Calendar(booking.getSince()), date2Calendar(booking.getUntil()), booking.getPrice());
	}

	private static Calendar date2Calendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	public static BookingEntity map(BookingTo booking) {
		return new BookingEntity(booking.getId(), CarMapper.map(booking.getCar()),
				RenterMapper.map(booking.getRenter()), new Date(booking.getSince().getTimeInMillis()),
				new Date(booking.getUntil().getTimeInMillis()), booking.getPrice());
	}

}
