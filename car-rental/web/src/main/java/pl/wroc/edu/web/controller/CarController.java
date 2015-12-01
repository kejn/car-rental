package pl.wroc.edu.web.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String home(Map<String, Object> params) {
		return "home";
	}

	@RequestMapping(value = "/cars", method = RequestMethod.GET)
	public String carList(Map<String, Object> params,
			@RequestParam(required = false) String manufacturer,
			@RequestParam(required = false) String location) {
		final List<CarTo> cars = carService.findCarsByParameters(manufacturer,location);
		putStaticData(params, cars);
		params.put("cars", cars);
		return "carList";
	}

	@RequestMapping(value = "/cars/details", method = RequestMethod.GET)
	public String carDetails(Map<String, Object> params,
			@RequestParam(required = false) BigDecimal id) {
//		final List<CarTo> cars = carService.findCarBookings(id);
//		putStaticData(params, cars);
//		params.put("cars", cars);
		return "carDetails";
	}
	
	private void putStaticData(Map<String, Object> params, List<CarTo> carList) {
		final List<LocationTo> uniqueLocations = DataExtractor.uniqueLocations(carList);
		final List<ModelTo> uniqueModels = DataExtractor.uniqueModels(carList);
		final List<ManufacturerTo> uniqueManufacturers = DataExtractor.uniqueManufacturers(uniqueModels);
		params.put("locations", uniqueLocations);
		params.put("manufacturers", uniqueManufacturers);
	}

}
