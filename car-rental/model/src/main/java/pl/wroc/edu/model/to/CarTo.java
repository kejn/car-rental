package pl.wroc.edu.model.to;

import java.math.BigDecimal;

import pl.wroc.edu.model.templates.IdAware;

public class CarTo implements IdAware {

	private BigDecimal id;
	private ModelTo model;
	private ColorTo color;
	private BodyTo body;
	private TransmissionTo transmission;
	private DriveWheelsTo driveWheels;
	private LocationTo location;
	private Short weight;
	private Short power;

	public CarTo(BigDecimal id, ModelTo model, ColorTo color, BodyTo body, TransmissionTo transmission, DriveWheelsTo driveWheels,
			LocationTo location, Short weight, Short power) {
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

	@Override
	public BigDecimal getId() {
		return id;
	}

	public ModelTo getModel() {
		return model;
	}

	public void setModel(ModelTo model) {
		this.model = model;
	}

	public ColorTo getColor() {
		return color;
	}

	public void setColor(ColorTo color) {
		this.color = color;
	}

	public BodyTo getBody() {
		return body;
	}

	public void setBody(BodyTo body) {
		this.body = body;
	}

	public TransmissionTo getTransmission() {
		return transmission;
	}

	public void setTransmission(TransmissionTo transmission) {
		this.transmission = transmission;
	}

	public DriveWheelsTo getDriveWheels() {
		return driveWheels;
	}

	public void setDriveWheels(DriveWheelsTo driveWheels) {
		this.driveWheels = driveWheels;
	}

	public LocationTo getLocation() {
		return location;
	}

	public void setLocation(LocationTo location) {
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
