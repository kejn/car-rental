package pl.wroc.edu.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = LocationEntity.tableName)
public class LocationEntity {

	protected static final String tableName = "LOCATIONS";
	private static final String sequenceName = "LOCATIONS_SEQ";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = sequenceName)
	@SequenceGenerator(name = sequenceName, sequenceName = sequenceName, allocationSize = 1)
	private BigDecimal id;
	
	@Column(nullable = false, length = 40)
	private String city;
	
	protected LocationEntity(){
	}
	
	public LocationEntity(BigDecimal id, String city) {
		this.id = id;
		this.city = city;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
