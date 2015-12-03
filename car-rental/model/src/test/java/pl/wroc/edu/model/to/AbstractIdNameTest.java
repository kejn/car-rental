package pl.wroc.edu.model.to;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

public class AbstractIdNameTest {
	
	private final AbstractIdName manufacturer = new ManufacturerTo(BigDecimal.ONE, "Name");
	private final Short year = 1999;

	/**
	 * AbstractIdName test 
	 */
	
	@Test
	public void testTheSameIdAndNameEqual() {
		//given
		final ManufacturerTo manufacturer2 = new ManufacturerTo(BigDecimal.ONE, "Name");
		//then
		assertTrue(manufacturer.equals(manufacturer2));
		assertTrue(manufacturer2.equals(manufacturer));
	}

	@Test
	public void testDifferentIdTheSameNameNotEqual() {
		//given
		final ManufacturerTo manufacturer2 = new ManufacturerTo(BigDecimal.TEN, "Name");
		//then
		assertFalse(manufacturer.equals(manufacturer2));
		assertFalse(manufacturer2.equals(manufacturer));
	}

	@Test
	public void testTheSameIdDifferentNameNotEqual() {
		//given
		final ManufacturerTo manufacturer2 = new ManufacturerTo(BigDecimal.ONE, "Name1");
		//then
		assertFalse(manufacturer.equals(manufacturer2));
		assertFalse(manufacturer2.equals(manufacturer));
	}

	/**
	 * AbstractIdName extensions comparison
	 */
	
	@Test
	public void testManufacturerIsNotLocation() {
		//given
		final LocationTo location = new LocationTo(manufacturer.getId(), manufacturer.getName());
		//then
		assertFalse(manufacturer.equals(location));
		assertFalse(location.equals(manufacturer));
	}

	@Test
	public void testManufacturerIsNotModel() {
		//given
		final ManufacturerTo manufacturer = (ManufacturerTo) this.manufacturer;
		final ModelTo model = new ModelTo(manufacturer.getId(), manufacturer.getName(), manufacturer, year);
		//then
		assertFalse(manufacturer.equals(model));
		assertFalse(model.equals(manufacturer));
	}
	
	/**
	 * Model test
	 */
	
	@Test
	public void testModelTheSameIdAndNameAndManufacturerAndYearEqual() {
		//given
		final ManufacturerTo manufacturer = (ManufacturerTo) this.manufacturer;
		final ModelTo model1 = new ModelTo(BigDecimal.ONE, "Model", manufacturer, year);
		final ModelTo model2 = new ModelTo(BigDecimal.ONE, "Model", manufacturer, year);
		//then
		assertTrue(model1.equals(model2));
		assertTrue(model2.equals(model1));
	}

	@Test
	public void testModelTheSameIdAndManufacturerAndYearDifferentNameNotEqual() {
		//given
		final ManufacturerTo manufacturer = (ManufacturerTo) this.manufacturer;
		final ModelTo model1 = new ModelTo(BigDecimal.ONE, "Model", manufacturer, year);
		final ModelTo model2 = new ModelTo(BigDecimal.ONE, "Model1", manufacturer, year);
		//then
		assertFalse(model1.equals(model2));
		assertFalse(model2.equals(model1));
	}

	@Test
	public void testModelTheSameIdAndNameAndYearDifferentManufacturerNotEqual() {
		//given
		final ManufacturerTo manufacturer1 = (ManufacturerTo) manufacturer;
		final ManufacturerTo manufacturer2 = new ManufacturerTo(BigDecimal.ONE, "Name1");
		final ModelTo model1 = new ModelTo(BigDecimal.ONE, "Model", manufacturer1, year);
		final ModelTo model2 = new ModelTo(BigDecimal.ONE, "Model", manufacturer2, year);
		//then
		assertFalse(model1.equals(model2));
		assertFalse(model2.equals(model1));
	}

	@Test
	public void testModelTheSameIdAndNameAndManufacturerDifferentYearNotEqual() {
		//given
		final Short year2 = 2000;
		final ManufacturerTo manufacturer = (ManufacturerTo) this.manufacturer;
		final ModelTo model1 = new ModelTo(BigDecimal.ONE, "Model", manufacturer, year);
		final ModelTo model2 = new ModelTo(BigDecimal.ONE, "Model", manufacturer, year2);
		//then
		assertFalse(model1.equals(model2));
		assertFalse(model2.equals(model1));
	}
}
