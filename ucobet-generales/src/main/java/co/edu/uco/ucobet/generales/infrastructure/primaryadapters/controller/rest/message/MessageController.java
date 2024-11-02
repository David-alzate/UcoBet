package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.message;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

@RestController
@RequestMapping("/general/api/v1/messages")
public class MessageController {

	private final MessageHelper messageHelper;

	public MessageController(MessageHelper messageHelper) {
		this.messageHelper = messageHelper;
	}

	@PostMapping("/create")
	public ResponseEntity<String> createMessage(@RequestParam String messageContent) {
		String messageCode = messageHelper.addMessageWithGeneratedCode(messageContent);
		return ResponseEntity.status(HttpStatus.CREATED).body("Mensaje creado con código: " + messageCode);
	}

	@GetMapping("/all")
	public ResponseEntity<Map<String, String>> getAllMessages() {
		Map<Object, Object> messages = messageHelper.getAllMessages();
		Map<String, String> formattedMessages = new HashMap<>();

		for (Map.Entry<Object, Object> entry : messages.entrySet()) {
			formattedMessages.put("" + entry.getKey(), (String) entry.getValue());
		}

		return ResponseEntity.ok(formattedMessages);
	}

	@DeleteMapping("/{code}")
	public ResponseEntity<String> deleteMessage(@PathVariable String code) {
		boolean deleted = messageHelper.deleteMessage(code);
		if (deleted) {
			return ResponseEntity.ok("Mensaje eliminado con código: " + code);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mensaje no encontrado para el código: " + code);
		}
	}
}
