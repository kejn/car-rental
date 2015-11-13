package pl.wroc.edu.model.to;

import java.math.BigDecimal;

import pl.wroc.edu.model.templates.AbstractIdType;
import pl.wroc.edu.model.types.BodyType;

public class BodyTo extends AbstractIdType {
	
	public BodyTo(BigDecimal id, Enum<BodyType> type) {
		super(id,type);
	}

}
