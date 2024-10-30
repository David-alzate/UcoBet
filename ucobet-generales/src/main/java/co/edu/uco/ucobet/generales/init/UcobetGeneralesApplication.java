package co.edu.uco.ucobet.generales.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.azure.security.keyvault.secrets.SecretClient;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.uco.ucobet"})
@EnableJpaRepositories("co.edu.uco.ucobet.generales.apication.secondaryports.repository")
@EntityScan("co.edu.uco.ucobet.generales.apication.secondaryports.entity")
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
        String h2url = secretClient.getSecret("passwordPostgrest").getValue();
        System.setProperty("passwordPostgrest", h2url);
        System.out.println("h2url: " + h2url);
    }
}

