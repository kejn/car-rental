package pl.wroc.edu.model.to;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import pl.wroc.edu.model.templates.AbstractIdType;
import pl.wroc.edu.model.types.BodyType;
import pl.wroc.edu.model.types.ColorType;
import pl.wroc.edu.model.types.DriveWheelsType;
import pl.wroc.edu.model.types.TransmissionType;

public class _To_TypeTestWithId1 {
	
	private final BigDecimal id = BigDecimal.ONE;

	@Test
	public void bodyIsSedan() {
		// given
		AbstractIdType body = new BodyTo(id, BodyType.SEDAN);
		// then
		assertEquals(id, body.getId());
		assertEquals(BodyType.SEDAN, body.getType());
	}

	@Test
	public void colorIsBlack() {
		// given
		AbstractIdType color = new ColorTo(id, ColorType.BLACK);
		// then
		assertEquals(id, color.getId());
		assertEquals(ColorType.BLACK, color.getType());
	}
	
	@Test
	public void driveWheelsIsFront() {
		// given
		AbstractIdType wheels = new DriveWheelsTo(id, DriveWheelsType.FRONT);
		// then
		assertEquals(id, wheels.getId());
		assertEquals(DriveWheelsType.FRONT, wheels.getType());
	}

	@Test
	public void transmissionIsAuto() {
		// given
		AbstractIdType transmission = new TransmissionTo(id, TransmissionType.AUTO);
		// then
		assertEquals(id, transmission.getId());
		assertEquals(TransmissionType.AUTO, transmission.getType());
	}

}
