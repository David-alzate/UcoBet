package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.sanitizer;

import org.owasp.encoder.Encode;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SanitizationInterceptor implements HandlerInterceptor {
	
	 @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

	        String inputParam = request.getParameter("inputParam");
	        if (inputParam != null) {
	            String sanitizedParam = Encode.forHtml(inputParam);
	            request.setAttribute("inputParam", sanitizedParam);
	        }
	        return true;
	    }

}
