package pl.wroc.edu.model.helper;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmptyStringTest {

	@Test
	public void testShouldReturnStringWithNoText() {
		// given
		final String nullString = null;
		// when
		final String result = EmptyString.safeValue(nullString);
		// then
		assertNotNull(result);
		assertEquals("", result);
	}

	@Test
	public void testShouldReturnEmptyString() {
		// given
		final String nullString = new String();
		// when
		final String result = EmptyString.safeValue(nullString);
		// then
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}

}
