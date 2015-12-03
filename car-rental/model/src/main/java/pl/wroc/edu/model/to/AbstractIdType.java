package pl.wroc.edu.model.to;

import java.math.BigDecimal;

import pl.wroc.edu.model.templates.IdAware;
import pl.wroc.edu.model.templates.TypeAware;

public abstract class AbstractIdType implements IdAware, TypeAware {

	protected BigDecimal id;
	protected Enum<?> type;
	
	public AbstractIdType(BigDecimal id, Enum<?> type) {
		this.id = id;
		this.type = type;
	}
	
	@Override
	public boolean equals(Object object) {
		if(object instanceof AbstractIdType) {
			AbstractIdType other = (AbstractIdType) object;
			return other.getId().equals(getId()) && other.getType().equals(getType());
		}
		return false;
	}

	@Override
	public BigDecimal getId() {
		return id;
	}

	@Override
	public Enum<?> getType() {
		return type;
	}
	
}
