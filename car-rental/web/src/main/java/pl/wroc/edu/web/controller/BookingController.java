package pl.wroc.edu.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.wroc.edu.jpa.service.BookingService;
import pl.wroc.edu.jpa.service.CarService;
import pl.wroc.edu.model.helper.BookingForm;
import pl.wroc.edu.model.to.BookingTo;
import pl.wroc.edu.model.to.CarTo;

@Controller
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private CarService carService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String bookCar(@ModelAttribute(value = "booking") BookingForm bookingForm, BindingResult errors, Map<String, Object> params) {
		if (errors.hasErrors()) {
			printErrors(errors);
		}
		CarTo car = carService.findCarById(bookingForm.getCarId());
		BookingTo booking = bookingForm.map2To(car);
		booking = bookingService.saveBooking(booking);
		String bookingString = stringJSON(booking);
		params.put("booking", bookingString);
		return "save";
	}

	private String stringJSON(Object object) {
		String result = null;
		try {
			result = new ObjectMapper().writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

	private void printErrors(BindingResult errors) {
		for (ObjectError error : errors.getAllErrors()) {
			System.out.println(error.getDefaultMessage());
		}
	}
}
