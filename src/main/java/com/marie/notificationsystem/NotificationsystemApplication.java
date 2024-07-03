package com.marie.notificationsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// es (exclude = {DataSourceAutoConfiguration.class }) davumate da eshveba magram db propertyebi gasaweria mainc
@SpringBootApplication
/*@EnableJpaRepositories(basePackages = "com.marie.notificationsystem.model.repository")*/
public class NotificationsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationsystemApplication.class, args);
	}

}
