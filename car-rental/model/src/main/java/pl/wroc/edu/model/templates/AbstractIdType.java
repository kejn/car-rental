package pl.wroc.edu.model.templates;

import java.math.BigDecimal;

public abstract class AbstractIdType implements IdAware, TypeAware {

	protected BigDecimal id;
	protected Enum<?> type;
	
	@Override
	public BigDecimal getId() {
		return id;
	}

	@Override
	public Enum<?> getType() {
		return type;
	}
	
	public AbstractIdType(BigDecimal id, Enum<?> type) {
		this.id = id;
		this.type = type;
	}
}
