package co.edu.uco.ucobet.generales.init;

import com.azure.security.keyvault.secrets.SecretClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller", 
                               "co.edu.uco.ucobet.generales.init.config" })
public class UcobetGeneralesApplication implements CommandLineRunner {

    private final SecretClient secretClient;

    public UcobetGeneralesApplication(SecretClient secretClient) {
        this.secretClient = secretClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(UcobetGeneralesApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // Recupera el secreto desde Azure Key Vault y establece la URL de la base de datos
        String h2url = secretClient.getSecret("spring-datasource-url").getValue();
        System.setProperty("spring.datasource.url", h2url);
        System.out.println("h2url: " + h2url);
    }
}

