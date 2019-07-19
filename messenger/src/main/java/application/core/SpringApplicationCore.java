package application.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages={"application.service"})
@EnableJpaRepositories(basePackages={"application.repo"})
@EntityScan(basePackages={"application.entity"})
public class SpringApplicationCore{
	public static void main(String[] args) {
		SpringApplication.run(SpringApplicationCore.class, args);
	}

}
