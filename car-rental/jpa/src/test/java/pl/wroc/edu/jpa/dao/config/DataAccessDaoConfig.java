package pl.wroc.edu.jpa.dao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import pl.wroc.edu.jpa.config.DataAccessConfig;
import pl.wroc.edu.jpa.dao.CarDao;
import pl.wroc.edu.jpa.dao.impl.CarDaoImpl;

@Configuration
@Import(DataAccessConfig.class)
public class DataAccessDaoConfig {
	
	@Bean
	CarDao carDao() {
		return new CarDaoImpl();
	}

}
