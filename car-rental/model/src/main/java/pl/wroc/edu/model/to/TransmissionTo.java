package pl.wroc.edu.model.to;

import java.math.BigDecimal;

import pl.wroc.edu.model.templates.AbstractIdType;
import pl.wroc.edu.model.types.TransmissionType;

public class TransmissionTo extends AbstractIdType {

	public TransmissionTo(BigDecimal id, Enum<TransmissionType> type) {
		super(id, type);
	}

}
