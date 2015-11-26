package pl.wroc.edu.web.dataextractor;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import pl.wroc.edu.model.to.BodyTo;
import pl.wroc.edu.model.to.CarTo;
import pl.wroc.edu.model.to.ColorTo;
import pl.wroc.edu.model.to.DriveWheelsTo;
import pl.wroc.edu.model.to.LocationTo;
import pl.wroc.edu.model.to.ManufacturerTo;
import pl.wroc.edu.model.to.ModelTo;
import pl.wroc.edu.model.to.TransmissionTo;
import pl.wroc.edu.model.types.BodyType;
import pl.wroc.edu.model.types.ColorType;
import pl.wroc.edu.model.types.DriveWheelsType;
import pl.wroc.edu.model.types.TransmissionType;

public class DataExtractorTest {
	private final Short year = 1999;
	private final ManufacturerTo manufacturer = new ManufacturerTo(BigDecimal.ONE, "manu");
	private final ModelTo model = new ModelTo(BigDecimal.ONE, "model", manufacturer, year);
	private final ColorTo color = new ColorTo(BigDecimal.ONE, ColorType.BLACK);
	private final BodyTo body = new BodyTo(BigDecimal.ONE, BodyType.SEDAN);
	private final TransmissionTo transmission = new TransmissionTo(BigDecimal.ONE, TransmissionType.AUTO);
	private final DriveWheelsTo wheels = new DriveWheelsTo(BigDecimal.ONE, DriveWheelsType.FRONT);
	private final LocationTo location = new LocationTo(BigDecimal.ONE, "loc");
	private final Short weight = 1200;
	private final Short power = 100;

	@Test
	public void testLocationsAreUnique() {
		// given
		LocationTo location1 = new LocationTo(new BigDecimal(2), "loc1");
		LocationTo location2 = new LocationTo(new BigDecimal(3), "loc2");
		final List<CarTo> cars = new ArrayList<>(
				Arrays.asList(new CarTo(BigDecimal.ONE, model, color, body, transmission, wheels, location, weight, power),
						new CarTo(BigDecimal.ONE, model, color, body, transmission, wheels, location, weight, power),
						new CarTo(BigDecimal.ONE, model, color, body, transmission, wheels, location1, weight, power),
						new CarTo(BigDecimal.ONE, model, color, body, transmission, wheels, location, weight, power),
						new CarTo(BigDecimal.ONE, model, color, body, transmission, wheels, location2, weight, power),
						new CarTo(BigDecimal.ONE, model, color, body, transmission, wheels, location1, weight, power)));
		// when
		final List<LocationTo> uniqueLocations = DataExtractor.uniqueLocations(cars);
		// then
		assertEquals(3, uniqueLocations.size());
	}

	@Test
	public void testModelsAreUnique() {
		// given
		final ModelTo model1 = new ModelTo(new BigDecimal(2), "model1", manufacturer, year);
		final ModelTo model2 = new ModelTo(new BigDecimal(2), "model2", manufacturer, year);
		final List<CarTo> cars = new ArrayList<>(
				Arrays.asList(new CarTo(BigDecimal.ONE, model, color, body, transmission, wheels, location, weight, power),
						new CarTo(BigDecimal.ONE, model, color, body, transmission, wheels, location, weight, power),
						new CarTo(BigDecimal.ONE, model1, color, body, transmission, wheels, location, weight, power),
						new CarTo(BigDecimal.ONE, model1, color, body, transmission, wheels, location, weight, power),
						new CarTo(BigDecimal.ONE, model2, color, body, transmission, wheels, location, weight, power),
						new CarTo(BigDecimal.ONE, model2, color, body, transmission, wheels, location, weight, power)));
		// when
		final List<ModelTo> uniqueModels = DataExtractor.uniqueModels(cars);
		// then
		assertEquals(3, uniqueModels.size());
	}

	@Test
	public void testManufacturersAreUnique() {
		// given
		final ManufacturerTo manufacturer1 = new ManufacturerTo(BigDecimal.ONE, "manu1");
		final ManufacturerTo manufacturer2 = new ManufacturerTo(BigDecimal.ONE, "manu2");
		final List<ModelTo> models = new ArrayList<>(
				Arrays.asList(new ModelTo(BigDecimal.ONE, "model", manufacturer, year),
						new ModelTo(BigDecimal.ONE, "model", manufacturer, year),
						new ModelTo(BigDecimal.ONE, "model", manufacturer1, year),
						new ModelTo(BigDecimal.ONE, "model", manufacturer1, year),
						new ModelTo(BigDecimal.ONE, "model", manufacturer2, year),
						new ModelTo(BigDecimal.ONE, "model", manufacturer2, year)));
		// when
		final List<ManufacturerTo> uniqueManufacturers = DataExtractor.uniqueManufacturers(models);
		// then
		assertEquals(3, uniqueManufacturers.size());
	}

}
