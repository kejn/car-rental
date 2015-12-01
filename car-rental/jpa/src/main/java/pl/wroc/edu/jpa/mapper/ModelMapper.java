package pl.wroc.edu.jpa.mapper;

import pl.wroc.edu.model.entity.ModelEntity;
import pl.wroc.edu.model.to.ModelTo;

public class ModelMapper {

	public static ModelTo map(ModelEntity model) {
		return new ModelTo(model.getId(), model.getName(), ManufacturerMapper.map(model.getManufacturer()),
				model.getYearOfProduction());
	}

	public static ModelEntity map(ModelTo model) {
		return new ModelEntity(model.getId(), model.getName(), ManufacturerMapper.map(model.getManufacturer()),
				model.getYearOfProduction());
	}

}
