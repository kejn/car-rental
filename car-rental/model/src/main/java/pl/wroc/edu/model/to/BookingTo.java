package pl.wroc.edu.model.to;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.concurrent.TimeUnit;

import pl.wroc.edu.model.templates.IdAware;

public class BookingTo implements IdAware {
	
	private static final Double pricePerDay = 100.0;
	
	private BigDecimal id;
	private CarTo car;
	private RenterTo renter;
	private Date since;
	private Date until;
	private Double price;
	
	public BookingTo(BigDecimal id, CarTo car, RenterTo renter, Date since, Date until, Double price) {
		this.id = id;
		this.car = car;
		this.renter = renter;
		this.since = since;
		this.until = until;
		this.price = price;
	}

	public BookingTo(BigDecimal id, CarTo car, RenterTo renter, Date since, Date until) {
		this.id = id;
		this.car = car;
		this.renter = renter;
		this.since = since;
		this.until = until;
		this.price = calculatePrice(); 
	}

	// number of days (until-since) * pricePerDay
	private Double calculatePrice() {
		long diff = until.getTime() - since.getTime();
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


	public Date getSince() {
		return since;
	}


	public void setSince(Date since) {
		this.since = since;
	}


	public Date getUntil() {
		return until;
	}


	public void setUntil(Date until) {
		this.until = until;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}

}
