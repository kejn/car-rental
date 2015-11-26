package pl.wroc.edu.web.dataextractor;

import java.util.List;
import java.util.stream.Collectors;

import pl.wroc.edu.model.to.CarTo;
import pl.wroc.edu.model.to.LocationTo;
import pl.wroc.edu.model.to.ManufacturerTo;
import pl.wroc.edu.model.to.ModelTo;

public class DataExtractor {

	public static List<LocationTo> uniqueLocations(List<CarTo> allCars) {
		return allCars.stream().map(CarTo::getLocation).unordered().distinct().collect(Collectors.toList());
	}

	public static List<ModelTo> uniqueModels(List<CarTo> allCars) {
		return allCars.stream().map(CarTo::getModel).unordered().distinct().collect(Collectors.toList());
	}

	public static List<ManufacturerTo> uniqueManufacturers(List<ModelTo> uniqueModels) {
		return uniqueModels.stream().map(ModelTo::getManufacturer).unordered().distinct().collect(Collectors.toList());
	}
	
}
