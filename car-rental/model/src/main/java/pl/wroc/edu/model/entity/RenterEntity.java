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
@Table(name = RenterEntity.tableName)
public class RenterEntity {
	
	protected static final String tableName = "RENTERS";
	private static final String sequenceName = "RENTERS_SEQ";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = sequenceName)
	@SequenceGenerator(name = sequenceName, sequenceName = sequenceName)
	private BigDecimal id;
	
	@Column(length = 40)
	private String name;
	
	@Column(length = 40)
	private String surname;

	@Column(nullable = false, length = 320)
	private String email;

	@Column(length = 9)
	private String phone;

}
