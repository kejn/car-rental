package pl.wroc.edu.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = CarEntity.tableName)
public class CarEntity {
	
	protected static final String tableName = "CARS";
	private static final String sequenceName = "CARS_SEQ";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = sequenceName)
	@SequenceGenerator(name = sequenceName, sequenceName = sequenceName, allocationSize = 1)
	private BigDecimal id;
	
	@ManyToOne
	@JoinColumn(name = "model", nullable = false)
	private ModelEntity model;
	
	@ManyToOne
	@JoinColumn(name = "color", nullable = false)
	private ColorEntity color;
	
	@ManyToOne
	@JoinColumn(name = "body", nullable = false)
	private BodyEntity body;

	@ManyToOne
	@JoinColumn(name = "transmission", nullable = false)
	private TransmissionEntity transmission;

	@ManyToOne
	@JoinColumn(name = "wheels", nullable = false)
	private DriveWheelsEntity driveWheels;

	@ManyToOne
	@JoinColumn(name = "location", nullable = false)
	private LocationEntity location;

	@Column(nullable = false)
	private Short weight; // Kilograms [kg]

	@Column(nullable = false)
	private Short power; // Horsepower [hp]
	
	protected CarEntity(){
	}

	public CarEntity(BigDecimal id, ModelEntity model, ColorEntity color, BodyEntity body,
			TransmissionEntity transmission, DriveWheelsEntity driveWheels, LocationEntity location, Short weight,
			Short power) {
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

	public Short getWeight() {
		return weight;
	}

	public void setWeight(Short weight) {
		this.weight = weight;
	}

	public Short getPower() {
		return power;
	}

	public void setPower(Short power) {
		this.power = power;
	}
	
}
