package pl.wroc.edu.model.to;

import java.math.BigDecimal;

import pl.wroc.edu.model.helper.EmptyString;
import pl.wroc.edu.model.templates.IdAware;
import pl.wroc.edu.model.templates.NameAware;

public abstract class AbstractIdName implements IdAware, NameAware {

	protected BigDecimal id;
	private String name;
	
	public AbstractIdName(BigDecimal id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public AbstractIdName() {
	}

	@Override
	public boolean equals(Object object) {
		if(object instanceof AbstractIdName) {
			AbstractIdName other = (AbstractIdName) object;
			return other.getId().equals(getId()) && other.getName().equals(getName());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return getId().hashCode();
	}

	@Override
	public BigDecimal getId() {
		return id;
	}

	@Override
	public String getName() {
		return EmptyString.safeValue(name);
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
