package co.edu.uco.ucobet.generales.crosscutting.helpers;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.springframework.stereotype.Service;

@Service
public class SanitizerHelper {

    public String sanitizeInput(String input) {
        if (input != null) {
            return Jsoup.clean(input, Safelist.basic());
        }
        return input;  // Retorna el valor original si es nulo
    }
}