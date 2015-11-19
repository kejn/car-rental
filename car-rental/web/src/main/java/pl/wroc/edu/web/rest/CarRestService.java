package pl.wroc.edu.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.wroc.edu.jpa.service.CarService;
import pl.wroc.edu.model.to.CarTo;

@Controller
@ResponseBody
public class CarRestService {
	
	@Autowired
	private CarService carService;
	
	@RequestMapping(value = "/car", method = RequestMethod.GET)
	public List<CarTo> findCarsByManufacturer(@RequestParam("manufacturer") String manufacturer) {
		return carService.findAllCars(); // TODO by manufacturer/location/etc
	}

}
