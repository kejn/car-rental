package pl.wroc.edu.jpa.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import pl.wroc.edu.jpa.dao.config.DataAccessDaoConfig;
import pl.wroc.edu.model.entity.AllCars;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DataAccessDaoConfig.class, loader=AnnotationConfigContextLoader.class)
public class CarDaoImplTest {
	
	@Autowired
	CarDao carDao;

	@Test
    public void testShouldFindCarById() {
        // given
        final BigDecimal carId = BigDecimal.ONE;
        // when
        AllCars carEntity = carDao.findOne(carId);
        // then
        assertNotNull(carEntity);
    }
	
	@Test
	public void testShouldFindAllBooksNoCriteria() {
		// given
		final long numberOfCarsInRepository = carDao.findAll().size(); 
		// when
		List<AllCars> carEntities = carDao.findByParameters(null, null);
		// then
		assertNotNull(carEntities);
		assertFalse(carEntities.isEmpty());
		assertEquals(numberOfCarsInRepository, carEntities.size());
	}


    @Test
    public void testShouldFindCarsByParameters() {
        // given
        final String carManufacturer = "Audi";
        final String carLocation = "Warszawa";
        // when
        List<AllCars> carEntities = carDao.findByParameters(carManufacturer, carLocation);
        // then
        assertNotNull(carEntities);
        assertFalse(carEntities.isEmpty());
        assertEquals(carManufacturer, carEntities.get(0).getModel().getManufacturer().getName());
        assertEquals(carLocation, carEntities.get(0).getLocation().getCity());
    }

    @Test
    public void testShouldFindCarsByParametersManufacturer() {
    	// given
    	final String carManufacturer = "Audi";
    	// when
    	List<AllCars> carEntities = carDao.findByParameters(carManufacturer, null);
    	// then
    	assertNotNull(carEntities);
    	assertFalse(carEntities.isEmpty());
    	assertEquals(carManufacturer, carEntities.get(0).getModel().getManufacturer().getName());
    }
    
    @Test
    public void testShouldFindCarsByParametersLocation() {
    	// given
    	final String carLocation = "Warszawa";
    	// when
    	List<AllCars> carEntities = carDao.findByParameters(null, carLocation);
    	// then
    	assertNotNull(carEntities);
    	assertFalse(carEntities.isEmpty());
    	assertEquals(carLocation, carEntities.get(0).getLocation().getCity());
    }

}
