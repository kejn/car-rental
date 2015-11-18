package pl.wroc.edu.jpa.mapper;

import pl.wroc.edu.model.entity.BodyEntity;
import pl.wroc.edu.model.to.BodyTo;
import pl.wroc.edu.model.types.BodyType;

public class BodyMapper {

	public static BodyTo map(BodyEntity body) {
		return new BodyTo(body.getId(), BodyType.valueOf(body.getType()));
	}

}
