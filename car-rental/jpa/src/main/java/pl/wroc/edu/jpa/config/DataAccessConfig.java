package pl.wroc.edu.jpa.config;

import java.io.IOException;
import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;

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

@Configuration
@Import(DatabaseConfig.class)
@EnableJpaRepositories(basePackages = { "pl.wroc.edu.jpa.repository" })
public class DataAccessConfig {

//	private static final String persistanceUnitName = "car-rental";
//	private static final String packagesToScan = "pl.wroc.edu.model.entity";
//
//	@Autowired
//	private DatabaseConfig databaseConfig;
//
//	@Bean
//	public PlatformTransactionManager txManager() throws SQLException, IOException {
//		return new JpaTransactionManager(entityManagerFactory());
//	}
//
//	@Bean
//	public EntityManagerFactory entityManagerFactory() throws SQLException, IOException {
//		LocalContainerEntityManagerFactoryBean eMFactory = new LocalContainerEntityManagerFactoryBean();
//		eMFactory.setPersistenceUnitName(persistanceUnitName);
//		eMFactory.setDataSource(databaseConfig.dataSource());
//		eMFactory.setJpaProperties(jpaProperties().getObject());
//		eMFactory.setJpaVendorAdapter(hibernateJpaVendorAdapter());
//		eMFactory.setPackagesToScan(packagesToScan);
//		return eMFactory.getObject();
//	}
//
//	@Bean
//	public PropertiesFactoryBean jpaProperties() throws IOException {
//		PropertiesFactoryBean properties = new PropertiesFactoryBean();
//		properties.setLocation(new ClassPathResource("config/jpa.properties"));
//		return properties;
//	}
//
//	@Bean
//	public JpaVendorAdapter hibernateJpaVendorAdapter() {
//		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//		adapter.setDatabase(Database.ORACLE);
//		adapter.setShowSql(true);
//		adapter.setGenerateDdl(true);
//		return adapter;
//	}
}
