package pl.wroc.edu.model.to;

import java.math.BigDecimal;

import pl.wroc.edu.model.templates.IdAware;
import pl.wroc.edu.model.templates.NameAware;

public abstract class AbstractIdName implements IdAware, NameAware {

	protected BigDecimal id;
	protected String name;
	
	public AbstractIdName(BigDecimal id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public BigDecimal getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}
}
