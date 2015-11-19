package pl.wroc.edu.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MANUFACTURERS")
public class ManufacturerEntity {
	
	@Id
//	@OneToOne(mappedBy = "manufacturer")
	private BigDecimal id;
	
	@Column(nullable = false, length = 40)
	private String name;
	
	protected ManufacturerEntity(){
	}
	
	public ManufacturerEntity(BigDecimal id, String name) {
		this.id = id;
		this.name = name;
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
}
