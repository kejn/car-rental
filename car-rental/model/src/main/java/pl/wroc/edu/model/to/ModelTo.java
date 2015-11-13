package pl.wroc.edu.model.to;

import java.math.BigDecimal;

import pl.wroc.edu.model.templates.AbstractIdName;

public class ModelTo extends AbstractIdName {
	
	private String manufacturer;
	private Short yearOfProduction;

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Short getYearOfProduction() {
		return yearOfProduction;
	}

	public void setYearOfProduction(Short yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}

	public ModelTo(BigDecimal id, String name, String manufacturer, Short yearOfProduction) {
		super(id, name);
		this.manufacturer = manufacturer;
		this.yearOfProduction = yearOfProduction;
	}

}
