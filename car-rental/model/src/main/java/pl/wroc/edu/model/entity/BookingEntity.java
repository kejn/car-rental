package pl.wroc.edu.model.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKING")
public class BookingEntity {

	@Id
	private BigDecimal id;
	
	@OneToOne
	@JoinColumn(name = "car")
	private CarEntity car;

	@OneToOne
	@JoinColumn(name = "renter")
	private RenterEntity renter;

	@Column(nullable = false)
	private Date since;

	@Column(nullable = false)
	private Date until;

	@Column(nullable = false)
	private Float price; // PLN
	
	protected BookingEntity(){
	}
	
	public BookingEntity(BigDecimal id, CarEntity car, RenterEntity renter, Date since, Date until, Float price) {
		this.id = id;
		this.car = car;
		this.renter = renter;
		this.since = since;
		this.until = until;
		this.price = price;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public CarEntity getCar() {
		return car;
	}

	public void setCar(CarEntity car) {
		this.car = car;
	}

	public RenterEntity getRenter() {
		return renter;
	}

	public void setRenter(RenterEntity renter) {
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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
}
