package pl.wroc.edu.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.wroc.edu.jpa.service.CarService;
import pl.wroc.edu.model.to.CarTo;

@Controller
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@RequestMapping(value = "/cars", method = RequestMethod.GET)
	public String carList(Map<String,Object> params) {
		final List<CarTo> allCars = carService.findAllCars();
		params.put("cars", allCars);
		return "carList";
	}

}
