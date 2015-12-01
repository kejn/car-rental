package pl.wroc.edu.jpa.mapper;

import pl.wroc.edu.model.entity.DriveWheelsEntity;
import pl.wroc.edu.model.to.DriveWheelsTo;
import pl.wroc.edu.model.types.DriveWheelsType;

public class DriveWheelsMapper {

	public static DriveWheelsTo map(DriveWheelsEntity driveWheels) {
		return new DriveWheelsTo(driveWheels.getId(), DriveWheelsType.valueOf(driveWheels.getType()));
	}

	public static DriveWheelsEntity map(DriveWheelsTo driveWheels) {
		return new DriveWheelsEntity(driveWheels.getId(), driveWheels.getType().toString());
	}

}
