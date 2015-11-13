package pl.wroc.edu.model.to;

import java.math.BigDecimal;

import pl.wroc.edu.model.templates.AbstractIdType;
import pl.wroc.edu.model.types.DriveWheelsType;

public class DriveWheelsTo extends AbstractIdType {

	public DriveWheelsTo(BigDecimal id, Enum<DriveWheelsType> type) {
		super(id, type);
	}

}
