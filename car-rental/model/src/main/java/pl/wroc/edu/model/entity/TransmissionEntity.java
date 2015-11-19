package pl.wroc.edu.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSMISSIONS")
public class TransmissionEntity {

	@Id
//	@OneToOne(mappedBy = "transmission")
	private BigDecimal id;
	
	@Column(nullable = false, length = 20)
	private String type;
	
	protected TransmissionEntity(){
	}
	
	public TransmissionEntity(BigDecimal id, String type) {
		this.id = id;
		this.type = type;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
