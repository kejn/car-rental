package pl.wroc.edu.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MODELS")
public class ModelEntity {
	
	@Id
//	@OneToOne(mappedBy = "model")
	private BigDecimal id;
	
	@Column(nullable = false, length = 40)
	private String name;
	
	@OneToOne
	@JoinColumn(name = "manufacturer")
	private ManufacturerEntity manufacturer;
	
	@Column
	private Short yearOfProduction;
	
	protected ModelEntity(){
	}

	public ModelEntity(BigDecimal id, String name, ManufacturerEntity manufacturer, Short yearOfProduction) {
		this.id = id;
		this.name = name;
		this.manufacturer = manufacturer;
		this.yearOfProduction = yearOfProduction;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ManufacturerEntity getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(ManufacturerEntity manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Short getYearOfProduction() {
		return yearOfProduction;
	}

	public void setYearOfProduction(Short yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}
	
}
