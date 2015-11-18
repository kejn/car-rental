package pl.wroc.edu.model.config;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@Import(DatabaseConfig.class)
public class DataAccessConfiguration {

	@Autowired
	DatabaseConfig databaseConfig;

	@Bean
	public PlatformTransactionManager txManager() throws SQLException {
		return new DataSourceTransactionManager(databaseConfig.dataSource());
	}

}
