package pl.wroc.edu.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CARS")
public class CarEntity {

	@Id
	private BigDecimal id;
	
	@OneToOne
	@JoinColumn(name = "model")
	private ModelEntity model;
	
	@OneToOne
	@JoinColumn(name = "color")
	private ColorEntity color;
	
	@OneToOne
	@JoinColumn(name = "body")
	private BodyEntity body;

	@OneToOne
	@JoinColumn(name = "transmission")
	private TransmissionEntity transmission;

	@OneToOne
	@JoinColumn(name = "wheels")
	private DriveWheelsEntity driveWheels;

	@OneToOne
	@JoinColumn(name = "location")
	private LocationEntity location;

	@Column
	private Integer weight; // Kilograms [kg]

	@Column
	private Integer power; // Horsepower [hp]
	
	protected CarEntity(){
	}

	public CarEntity(BigDecimal id, ModelEntity model, ColorEntity color, BodyEntity body,
			TransmissionEntity transmission, DriveWheelsEntity driveWheels, LocationEntity location, Integer weight,
			Integer power) {
		this.id = id;
		this.model = model;
		this.color = color;
		this.body = body;
		this.transmission = transmission;
		this.driveWheels = driveWheels;
		this.location = location;
		this.weight = weight;
		this.power = power;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public ModelEntity getModel() {
		return model;
	}

	public void setModel(ModelEntity model) {
		this.model = model;
	}

	public ColorEntity getColor() {
		return color;
	}

	public void setColor(ColorEntity color) {
		this.color = color;
	}

	public BodyEntity getBody() {
		return body;
	}

	public void setBody(BodyEntity body) {
		this.body = body;
	}

	public TransmissionEntity getTransmission() {
		return transmission;
	}

	public void setTransmission(TransmissionEntity transmission) {
		this.transmission = transmission;
	}

	public DriveWheelsEntity getDriveWheels() {
		return driveWheels;
	}

	public void setDriveWheels(DriveWheelsEntity driveWheels) {
		this.driveWheels = driveWheels;
	}

	public LocationEntity getLocation() {
		return location;
	}

	public void setLocation(LocationEntity location) {
		this.location = location;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}
	
}
