package pl.wroc.edu.jpa.mapper;

import pl.wroc.edu.model.entity.ColorEntity;
import pl.wroc.edu.model.to.ColorTo;
import pl.wroc.edu.model.types.ColorType;

public class ColorMapper {

	public static ColorTo map(ColorEntity color) {
		return new ColorTo(color.getId(), ColorType.valueOf(color.getType()));
	}

	public static ColorEntity map(ColorTo color) {
		return new ColorEntity(color.getId(), color.getType().toString());
	}

}
