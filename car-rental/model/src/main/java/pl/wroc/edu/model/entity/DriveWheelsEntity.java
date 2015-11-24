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
@Table(name = DriveWheelsEntity.tableName)
public class DriveWheelsEntity {

	protected static final String tableName = "WHEELS";
	private static final String sequenceName = "WHEELS_SEQ";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = sequenceName)
	@SequenceGenerator(name = sequenceName, sequenceName = sequenceName)
	private BigDecimal id;
	
	@Column(nullable = false, length = 20)
	private String type;
	
	protected DriveWheelsEntity(){
	}
	
	public DriveWheelsEntity(BigDecimal id, String type) {
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
