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
import pl.wroc.edu.model.helper.BookingForm;
import pl.wroc.edu.model.to.CarTo;
import pl.wroc.edu.model.to.LocationTo;
import pl.wroc.edu.model.to.ManufacturerTo;
import pl.wroc.edu.model.to.ModelTo;
import pl.wroc.edu.model.to.RenterTo;
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
	public String carList(Map<String, Object> params, @RequestParam(required = false) String manufacturer,
			@RequestParam(required = false) String location) {
		final List<CarTo> cars = carService.findCarsByParameters(manufacturer, location);
		final List<LocationTo> uniqueLocations = DataExtractor.uniqueLocations(cars);
		final List<ModelTo> uniqueModels = DataExtractor.uniqueModels(cars);
		final List<ManufacturerTo> uniqueManufacturers = DataExtractor.uniqueManufacturers(uniqueModels);
		params.put("locations", uniqueLocations);
		params.put("manufacturers", uniqueManufacturers);
		params.put("cars", cars);
		return "carList";
	}

	@RequestMapping(value = "/cars/details", method = RequestMethod.GET)
	public String carDetails(Map<String, Object> params, @RequestParam BigDecimal id) {
		final CarTo car = carService.findCarById(id);
		RenterTo renter = new RenterTo();
		BookingForm booking = new BookingForm(renter);
		params.put("booking", booking);
		params.put("car", car);
		return "carDetails";
	}
}
