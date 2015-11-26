package pl.wroc.edu.jpa.config;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import(DatabaseConfig.class)
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "pl.wroc.edu.jpa.repository", "pl.wroc.edu.jpa.dao" })
public class DataAccessConfig {

	public static final String PERSISTANCE_UNIT_NAME = "carRentalPersistance";
	private static final String packagesToScan = "pl.wroc.edu.model.entity";

	@Autowired
	private DatabaseConfig databaseConfig;

	@Autowired
	private JpaVendorAdapter hibernateJpaVendorAdapter;

	@Bean
	public PlatformTransactionManager transactionManager() throws SQLException, IOException {
		return new JpaTransactionManager(entityManagerFactory().getObject());
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws SQLException, IOException {
		LocalContainerEntityManagerFactoryBean eMFactory = new LocalContainerEntityManagerFactoryBean();
		eMFactory.setPersistenceUnitName(PERSISTANCE_UNIT_NAME);
		eMFactory.setDataSource(databaseConfig.dataSource());
		eMFactory.setJpaProperties(jpaProperties().getObject());
		eMFactory.setJpaVendorAdapter(hibernateJpaVendorAdapter);
		eMFactory.setPackagesToScan(packagesToScan);
		return eMFactory;
	}
	
	@Bean
	public PropertiesFactoryBean jpaProperties() {
		PropertiesFactoryBean properties = new PropertiesFactoryBean();
		properties.setLocation(new ClassPathResource("config/jpa.properties"));
		return properties;
	}

	@Configuration
	static class VendorAdapter {
		@Bean
		public JpaVendorAdapter hibernateJpaVendorAdapter() {
			HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
			adapter.setDatabase(Database.ORACLE);
			adapter.setShowSql(true);
			adapter.setGenerateDdl(true);
			return adapter;
		}
	}
}
