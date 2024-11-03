package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.notificationservice;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class NotificationService {
	
	private final SendGrid sendGrid;

    public NotificationService(SendGrid sendGrid) {
        this.sendGrid = sendGrid;
    }

    public void sendNotification(String toEmail, String subject, String message) throws IOException {
        Email from = new Email("juanjoseaq99@gmail.com");
        Email to = new Email(toEmail);
        Content content = new Content("text/plain", message);
        Mail mail = new Mail(from, subject, to, content);

        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendGrid.api(request);
            System.out.println("Email sent! Status code: " + response.getStatusCode());
        } catch (IOException ex) {
            throw ex;
        }
    }

}
