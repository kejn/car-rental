package pl.wroc.edu.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"pl.wroc.edu"})
@Import({MvcConfig.class, ThymeleafConfig.class})
public class WebConfig {
}
