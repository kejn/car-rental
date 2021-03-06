package pl.wroc.edu.model.to;

import java.math.BigDecimal;

import pl.wroc.edu.model.types.BodyType;

public class BodyTo extends AbstractIdType {
	
	public BodyTo(BigDecimal id, Enum<BodyType> type) {
		super(id,type);
	}
	
	@Override
	public boolean equals(Object object) {
		return (object instanceof BodyTo) && super.equals(object);
	}

}
