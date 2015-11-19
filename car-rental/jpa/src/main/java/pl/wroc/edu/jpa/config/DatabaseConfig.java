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

//	@Value("${oracle.driver}")
//	private String driver;
//	
//	@Value("${oracle.server}")
//	private String server;
//
//	@Value("${oracle.port}")
//	private String port;
//
//	@Value("${oracle.service}")
//	private String service;
	

	@Bean
	public DataSource dataSource() throws SQLException {
		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setURL(url);
//		dataSource.setDriverType(driver);
//		dataSource.setServerName(server);
//		dataSource.setServiceName(service);
//		System.out.println(user);
//		dataSource.setPortNumber(Integer.parseInt(port));
		return dataSource;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
