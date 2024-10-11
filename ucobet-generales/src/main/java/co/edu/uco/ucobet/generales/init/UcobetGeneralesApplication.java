package co.edu.uco.ucobet.generales.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller", "co.edu.uco.ucobet.generales.init.config" })
public class UcobetGeneralesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UcobetGeneralesApplication.class, args);
	}

}
