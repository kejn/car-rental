package pl.wroc.edu.model.to;

import java.math.BigDecimal;

public class ManufacturerTo extends AbstractIdName {

	public ManufacturerTo(BigDecimal id, String name) {
		super(id, name);
	}
	
	@Override
	public boolean equals(Object object) {
		if(super.equals(object) && object instanceof ManufacturerTo) {
			ManufacturerTo other = (ManufacturerTo) object;
			return other.id.equals(id) && other.name.equals(name);
		}
		return false;
	}
	

}
