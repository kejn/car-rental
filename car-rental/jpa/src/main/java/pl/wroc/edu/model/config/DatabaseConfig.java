package pl.wroc.edu.model.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
@PropertySource(value = "classpath:config/jdbc.properties", ignoreResourceNotFound = false)
public class DatabaseConfig {

	@Value("${jdbc.user}")
	private String user;
	
	@Value("${jdbc.password}")
	private String password;
	
	@Value("${jdbc.url}")
	private String jdbcUrl;
	
	@Bean
	public DataSource dataSource() throws SQLException {
		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setURL(jdbcUrl);
		return dataSource;
	}

}
