package pl.wroc.edu.jpa.mapper;

import java.util.List;
import java.util.stream.Collectors;

import pl.wroc.edu.model.entity.CarEntity;
import pl.wroc.edu.model.to.CarTo;

public class CarMapper {

	public static CarTo map(CarEntity carEntity) {
		return new CarTo(carEntity.getId(),
				ModelMapper.map(carEntity.getModel()),
				ColorMapper.map(carEntity.getColor()),
				BodyMapper.map(carEntity.getBody()),
				TransmissionMapper.map(carEntity.getTransmission()),
				DriveWheelsMapper.map(carEntity.getDriveWheels()),
				LocationMapper.map(carEntity.getLocation()),
				carEntity.getWeight(),
				carEntity.getPower());
	}

	public static List<CarTo> map2To(List<CarEntity> cars) {
		return cars.stream().map(CarMapper::map).collect(Collectors.toList());
	}

}
