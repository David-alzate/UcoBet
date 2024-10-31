package co.edu.uco.ucobet.generales.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "co.edu.uco.ucobet" })
@EnableJpaRepositories("co.edu.uco.ucobet.generales.apication.secondaryports.repository")
@EntityScan("co.edu.uco.ucobet.generales.apication.secondaryports.entity")
public class UcobetGeneralesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UcobetGeneralesApplication.class, args);
	}

}
