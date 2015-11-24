package pl.wroc.edu.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = ModelEntity.tableName)
public class ModelEntity {
	
	protected static final String tableName = "MODELS";
	private static final String sequenceName = "MODELS_SEQ";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = sequenceName)
	@SequenceGenerator(name = sequenceName, sequenceName = sequenceName)
	private BigDecimal id;
	
	@Column(nullable = false, length = 40)
	private String name;
	
	@OneToOne
	@JoinColumn(name = "manufacturer", nullable = false)
	private ManufacturerEntity manufacturer;
	
	@Column(name = "year", nullable = false)
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
