package pl.wroc.edu.jpa.mapper;

import pl.wroc.edu.model.entity.LocationEntity;
import pl.wroc.edu.model.to.LocationTo;

public class LocationMapper {

	public static LocationTo map(LocationEntity location) {
		return new LocationTo(location.getId(), location.getCity());
	}

}
