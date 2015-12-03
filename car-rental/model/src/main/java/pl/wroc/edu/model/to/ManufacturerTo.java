package pl.wroc.edu.model.to;

import java.math.BigDecimal;

public class ManufacturerTo extends AbstractIdName {

	public ManufacturerTo(BigDecimal id, String name) {
		super(id, name);
	}
	
	@Override
	public boolean equals(Object object) {
		return (object instanceof ManufacturerTo) && super.equals(object);
	}
	

}
