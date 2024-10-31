package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.sanitizer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.sanitizer.SanitizationInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Autowired
    private SanitizationInterceptor sanitizationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sanitizationInterceptor);
    }

}
