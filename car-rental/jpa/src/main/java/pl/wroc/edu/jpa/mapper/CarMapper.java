package pl.wroc.edu.jpa.mapper;

import java.util.List;
import java.util.stream.Collectors;

import pl.wroc.edu.model.entity.AllCars;
import pl.wroc.edu.model.entity.CarEntity;
import pl.wroc.edu.model.to.CarTo;

public class CarMapper {

	public static CarTo map(AllCars car) {
		return new CarTo(car.getId(), ModelMapper.map(car.getModel()), ColorMapper.map(car.getColor()),
				BodyMapper.map(car.getBody()), TransmissionMapper.map(car.getTransmission()),
				DriveWheelsMapper.map(car.getDriveWheels()), LocationMapper.map(car.getLocation()), car.getWeight(),
				car.getPower());
	}

	public static CarTo map(CarEntity car) {
		return new CarTo(car.getId(), ModelMapper.map(car.getModel()), ColorMapper.map(car.getColor()),
				BodyMapper.map(car.getBody()), TransmissionMapper.map(car.getTransmission()),
				DriveWheelsMapper.map(car.getDriveWheels()), LocationMapper.map(car.getLocation()), car.getWeight(),
				car.getPower());
	}

	public static List<CarTo> map2To(List<AllCars> cars) {
		return cars.stream().map(CarMapper::map).collect(Collectors.toList());
	}

	public static CarEntity view2Table(AllCars car) {
		return new CarEntity(car.getId(), car.getModel(), car.getColor(), car.getBody(), car.getTransmission(),
				car.getDriveWheels(), car.getLocation(), car.getWeight(), car.getPower());
	}

	public static List<CarEntity> map2Entity(List<AllCars> cars) {
		return cars.stream().map(CarMapper::view2Table).collect(Collectors.toList());
	}

	public static CarEntity map(CarTo car) {
		return new CarEntity(car.getId(), ModelMapper.map(car.getModel()), ColorMapper.map(car.getColor()),
				BodyMapper.map(car.getBody()), TransmissionMapper.map(car.getTransmission()),
				DriveWheelsMapper.map(car.getDriveWheels()), LocationMapper.map(car.getLocation()), car.getWeight(),
				car.getPower());
	}

}
