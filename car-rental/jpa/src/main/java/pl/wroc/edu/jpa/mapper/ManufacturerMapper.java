package pl.wroc.edu.jpa.mapper;

import pl.wroc.edu.model.entity.ManufacturerEntity;
import pl.wroc.edu.model.to.ManufacturerTo;

public class ManufacturerMapper {

	public static ManufacturerTo map2To(ManufacturerEntity manufacturer) {
		return new ManufacturerTo(manufacturer.getId(), manufacturer.getName());
	}

}
