package pl.wroc.edu.jpa.mapper;

import pl.wroc.edu.model.entity.TransmissionEntity;
import pl.wroc.edu.model.to.TransmissionTo;
import pl.wroc.edu.model.types.TransmissionType;

public class TransmissionMapper {

	public static TransmissionTo map(TransmissionEntity transmission) {
		return new TransmissionTo(transmission.getId(), TransmissionType.valueOf(transmission.getType()));
	}

}
