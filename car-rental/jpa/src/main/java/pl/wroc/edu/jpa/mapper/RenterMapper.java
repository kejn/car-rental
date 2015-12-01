package pl.wroc.edu.jpa.mapper;

import pl.wroc.edu.model.entity.RenterEntity;
import pl.wroc.edu.model.to.RenterTo;

public class RenterMapper {

	public static RenterTo map(RenterEntity renter) {
		return new RenterTo(renter.getId(), renter.getName(), renter.getSurname(), renter.getEmail(),
				renter.getPhone());
	}

	public static RenterEntity map(RenterTo renter) {
		return new RenterEntity(renter.getId(), renter.getName(), renter.getSurname(), renter.getEmail(),
				renter.getPhone());
	}

}
