package pl.wroc.edu.model.to;

import java.math.BigDecimal;

import pl.wroc.edu.model.helper.EmptyString;
import pl.wroc.edu.model.templates.AbstractIdName;

public class RenterTo extends AbstractIdName {
	
	private String surname;
	private String email;
	private String phone;

	public String getSurname() {
		return EmptyString.safeValue(surname);
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return EmptyString.safeValue(phone);
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String getName() {
		return EmptyString.safeValue(name);
	}

	public RenterTo(BigDecimal id, String name, String surname, String email, String phone) {
		super(id, name);
		this.surname = surname;
		this.email = email;
		this.phone = phone;
	}

	public RenterTo(BigDecimal id, String email) {
		super(id, null);
		this.email = email;
	}

}
