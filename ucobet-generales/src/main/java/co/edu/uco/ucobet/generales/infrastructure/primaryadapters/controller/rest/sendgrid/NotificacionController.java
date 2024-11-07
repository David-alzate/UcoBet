package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.sendgrid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.notificationservice.NotificationService;
import co.edu.uco.ucobet.generales.crosscutting.exception.NotificationServiceException;

@RestController
@RequestMapping("/general/api/v1/sendgrid")
public class NotificacionController {

    private final NotificationService notificationService;

    public NotificacionController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/send-notification")
    public ResponseEntity<String> enviarNotificacion() {
        try {
            notificationService.sendNotification("monnodavid03@gmail.com", "UcoBet", "Este es un mensaje de prueba");
            return new ResponseEntity<>("Notificación enviada con éxito", HttpStatus.OK);
        } catch (NotificationServiceException e) {
            return new ResponseEntity<>("Error al enviar la notificación: " + e.getUserMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
