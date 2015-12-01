package pl.wroc.edu.jpa.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
@PropertySource(value = "classpath:config/oracle.properties", ignoreResourceNotFound = false)
public class DatabaseConfig {

	@Value("${oracle.user}")
	private String user;

	@Value("${oracle.password}")
	private String password;

	@Value("${oracle.url}")
	private String url;

	@Bean
	public DataSource dataSource() throws SQLException {
		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setURL(url);
		return dataSource;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
