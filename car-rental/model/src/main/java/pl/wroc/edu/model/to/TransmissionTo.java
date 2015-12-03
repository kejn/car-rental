package pl.wroc.edu.model.to;

import java.math.BigDecimal;

import pl.wroc.edu.model.types.TransmissionType;

public class TransmissionTo extends AbstractIdType {

	public TransmissionTo(BigDecimal id, Enum<TransmissionType> type) {
		super(id, type);
	}

	@Override
	public boolean equals(Object object) {
		return (object instanceof TransmissionTo) && super.equals(object);
	}
}
