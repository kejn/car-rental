package pl.wroc.edu.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RENTERS")
public class RenterEntity {
	
	@Id
//	@OneToOne(mappedBy = "renter")
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
