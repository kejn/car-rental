package pl.wroc.edu.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.wroc.edu.jpa.service.CarService;
import pl.wroc.edu.model.to.CarTo;
import pl.wroc.edu.model.to.LocationTo;
import pl.wroc.edu.model.to.ManufacturerTo;
import pl.wroc.edu.model.to.ModelTo;
import pl.wroc.edu.web.dataextractor.DataExtractor;

@Controller
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Map<String,Object> params) {
		return "home";
	}

	@RequestMapping(value = "/cars", method = RequestMethod.GET)
	public String carList(Map<String,Object> params) {
		final List<CarTo> allCars = carService.findAllCars();
		final List<ModelTo> uniqueModels = DataExtractor.uniqueModels(allCars);
		final List<LocationTo> uniqueLocations = DataExtractor.uniqueLocations(allCars);
		final List<ManufacturerTo> uniqueManufacturers = DataExtractor.uniqueManufacturers(uniqueModels);
		params.put("cars", allCars);
//		params.put("models", uniqueModels);
		params.put("locations", uniqueLocations);
		params.put("manufacturers", uniqueManufacturers);
		return "carList";
	}

}
