package pl.wroc.edu.model.to;

import java.math.BigDecimal;

import pl.wroc.edu.model.types.ColorType;

public class ColorTo extends AbstractIdType {

	public ColorTo(BigDecimal id, Enum<ColorType> type) {
		super(id, type);
	}

}
