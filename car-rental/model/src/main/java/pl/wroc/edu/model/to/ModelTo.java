package pl.wroc.edu.model.to;

import java.math.BigDecimal;

public class ModelTo extends AbstractIdName {
	
	private ManufacturerTo manufacturer;
	private Short yearOfProduction;

	public ModelTo(BigDecimal id, String name, ManufacturerTo manufacturer, Short yearOfProduction) {
		super(id, name);
		this.manufacturer = manufacturer;
		this.yearOfProduction = yearOfProduction;
	}
	
	@Override
	public String toString() {
		return manufacturer.name + " " + name;
	}
	
	public ManufacturerTo getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(ManufacturerTo manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Short getYearOfProduction() {
		return yearOfProduction;
	}

	public void setYearOfProduction(Short yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}

}
