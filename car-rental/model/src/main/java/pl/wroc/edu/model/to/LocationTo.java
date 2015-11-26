package pl.wroc.edu.model.to;

import java.math.BigDecimal;

public class LocationTo extends AbstractIdName {

	// here name is for city name 
	public LocationTo(BigDecimal id, String name) {
		super(id, name);
	}
	
	@Override
	public boolean equals(Object object) {
		return (object instanceof LocationTo) && super.equals(object);
	}

}
