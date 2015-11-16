package pl.wroc.edu.model.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DatabaseConfig.class)
public class DataAccessConfiguration {

//   @Bean
//   public PlatformTransactionManager transactionManager() {
//     PlatformTransactionManager transactionManager
//                = new BasicDataSourceTransactionManager();
//     transactionManager.setDataSource(dataSource());
//     return transactionManager;
//   }

}
