package pl.wroc.edu.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOCATIONS")
public class LocationEntity {

	@Id
//	@OneToOne(mappedBy = "location")
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
