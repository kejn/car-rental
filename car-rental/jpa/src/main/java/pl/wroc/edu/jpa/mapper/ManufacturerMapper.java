package pl.wroc.edu.jpa.mapper;

import pl.wroc.edu.model.entity.ManufacturerEntity;
import pl.wroc.edu.model.to.ManufacturerTo;

public class ManufacturerMapper {

	public static ManufacturerTo map(ManufacturerEntity manufacturer) {
		return new ManufacturerTo(manufacturer.getId(), manufacturer.getName());
	}

	public static ManufacturerEntity map(ManufacturerTo manufacturer) {
		return new ManufacturerEntity(manufacturer.getId(), manufacturer.getName());
	}

}
