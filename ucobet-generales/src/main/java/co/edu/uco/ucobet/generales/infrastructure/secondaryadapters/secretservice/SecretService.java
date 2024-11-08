package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.secretservice;

import org.springframework.stereotype.Service;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;

@Service
public class SecretService {
    private final SecretClient secretClient;

    public SecretService(SecretClient secretClient) {
        this.secretClient = secretClient;
    }

    public String getSecretValue(String key) {
        KeyVaultSecret secret = secretClient.getSecret(key);
        return secret.getValue();
    }
}