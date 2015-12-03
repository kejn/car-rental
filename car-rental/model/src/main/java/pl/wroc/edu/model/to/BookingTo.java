package pl.wroc.edu.model.to;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import pl.wroc.edu.model.templates.IdAware;

public class BookingTo implements IdAware {
	
	private static final Double pricePerDay = 100.0;
	
	private BigDecimal id;
	private CarTo car;
	private RenterTo renter;
	private Calendar since;
	private Calendar until;
	private Double price;
	
	public BookingTo(BigDecimal id, CarTo car, RenterTo renter, Calendar since, Calendar until, Double price) {
		this.id = id;
		this.car = car;
		this.renter = renter;
		this.since = since;
		this.until = until;
		this.price = price;
	}

	public BookingTo(BigDecimal id, CarTo car, RenterTo renter, Calendar since, Calendar until) {
		this.id = id;
		this.car = car;
		this.renter = renter;
		this.since = since;
		this.until = until;
		this.price = calculatePrice(); 
	}

	public BookingTo() {
	}

	// number of days (until-since) * pricePerDay
	private Double calculatePrice() {
		long diff = until.getTimeInMillis() - since.getTimeInMillis();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) * pricePerDay;
	}

	@Override
	public BigDecimal getId() {
		return id;
	}


	public CarTo getCar() {
		return car;
	}

	public void setCar(CarTo car) {
		this.car = car;
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

	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
