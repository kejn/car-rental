package pl.wroc.edu.web.controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import pl.wroc.edu.jpa.service.BookingService;
import pl.wroc.edu.jpa.service.CarService;
import pl.wroc.edu.model.to.BookingTo;
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

	@Autowired
	private BookingService bookingService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Map<String, Object> params) {
		return "home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String carDetailsPost(@ModelAttribute(value = "booking") BookingTo booking, BindingResult errors) {
		if (errors.hasErrors()) {
			printErrors(errors);
		}
		try {
			System.out.println(new ObjectMapper().writeValueAsString(booking));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		booking = bookingService.saveBooking(booking);
		System.out.println(new Date(booking.getSince().getTimeInMillis()));
		System.out.println(new Date(booking.getUntil().getTimeInMillis()));
		return "home";
	}

	private void printErrors(BindingResult errors) {
		for (ObjectError error : errors.getAllErrors()) {
			System.out.println(error.getDefaultMessage());
		}
	}

	@RequestMapping(value = "/cars", method = RequestMethod.GET)
	public String carList(Map<String, Object> params, @RequestParam(required = false) String manufacturer,
			@RequestParam(required = false) String location) {
		final List<CarTo> cars = carService.findCarsByParameters(manufacturer, location);
		putStaticData(params, cars);
		params.put("cars", cars);
		return "carList";
	}

	private void putStaticData(Map<String, Object> params, List<CarTo> carList) {
		final List<LocationTo> uniqueLocations = DataExtractor.uniqueLocations(carList);
		final List<ModelTo> uniqueModels = DataExtractor.uniqueModels(carList);
		final List<ManufacturerTo> uniqueManufacturers = DataExtractor.uniqueManufacturers(uniqueModels);
		params.put("locations", uniqueLocations);
		params.put("manufacturers", uniqueManufacturers);
	}

	@RequestMapping(value = "/cars/details", method = RequestMethod.GET)
	public String carDetails(Map<String, Object> params, @RequestParam BigDecimal id) {
		final CarTo car = carService.findCarById(id);
		BookingTo booking = new BookingTo();
		RenterTo renter = new RenterTo();
		booking.setCar(car);
		booking.setRenter(renter);
		params.put("car", car);
		params.put("booking", booking);
		return "carDetails";
	}
}
