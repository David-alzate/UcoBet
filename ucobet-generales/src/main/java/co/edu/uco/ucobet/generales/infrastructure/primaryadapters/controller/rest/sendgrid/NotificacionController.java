package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.sendgrid;

import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.notificationservice.NotificationService;

@RestController
@RequestMapping("/general/api/v1/sendgrid")
public class NotificacionController {

	private final NotificationService notificationService;

	public NotificacionController(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	@PostMapping("/send-notification")
	public String enviarNotificacion() {
		try {
			notificationService.sendNotification("monnodavid03@gmail.com", "UcoBet",
					"Este Es un mensaje de prueba");
			return "Notificación enviada";
		} catch (IOException e) {
			return "Error al enviar la notificación: " + e.getMessage();
		}
	}

}
	