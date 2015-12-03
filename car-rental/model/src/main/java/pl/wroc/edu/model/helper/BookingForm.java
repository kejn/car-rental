package pl.wroc.edu.model.helper;

import java.math.BigDecimal;
import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

import pl.wroc.edu.model.to.BookingTo;
import pl.wroc.edu.model.to.CarTo;
import pl.wroc.edu.model.to.RenterTo;

public class BookingForm {
	
	private BigDecimal carId;
	private RenterTo renter;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar since;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar until;
	
	public BookingForm(BigDecimal carId, RenterTo renter, Calendar since, Calendar until) {
		this.carId = carId;
		this.renter = renter;
		this.since = since;
		this.until = until;
	}
	
	public BookingForm(){
	}

	public BookingForm(RenterTo renter) {
		this.renter = renter;
	}

	/**
	 * @return Equivalent BookingTo object using specified CarTo object
	 */
	public BookingTo map2To(CarTo car) {
		return new BookingTo(null, car, renter, since, until);
	}
	
	public BigDecimal getCarId() {
		return carId;
	}

	public void setCarId(BigDecimal carId) {
		this.carId = carId;
	}


	public RenterTo getRenter() {
		return renter;
	}

	public void setRenter(RenterTo renter) {
		this.renter = renter;
	}


	public Calendar getSince() {
		return since;
	}

	public void setSince(Calendar since) {
		this.since = since;
	}


	public Calendar getUntil() {
		return until;
	}

	public void setUntil(Calendar until) {
		this.until = until;
	}

}
