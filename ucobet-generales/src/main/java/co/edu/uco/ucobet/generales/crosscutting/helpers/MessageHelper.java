package co.edu.uco.ucobet.generales.crosscutting.helpers;

import java.util.Map;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.RedisMessageCatalog;

@Component
public class MessageHelper {

	private static final String MESSAGE = "messages";

	private final RedisMessageCatalog messageCatalog;
	private final RedisTemplate<String, String> redisTemplate;

	public MessageHelper(RedisMessageCatalog messageCatalog, RedisTemplate<String, String> redisTemplate) {
		this.messageCatalog = messageCatalog;
		this.redisTemplate = redisTemplate;
	}

	public String addMessageWithGeneratedCode(String messageContent) {
		String code = messageCatalog.generateNextMessageCode();
		messageCatalog.addMessage(code, messageContent);
		return code;
	}

	public String getMessage(String code) {
		Object message = redisTemplate.opsForHash().get(MESSAGE, code);
		return message != null ? message.toString() : null;
	}

	public Map<Object, Object> getAllMessages() {
		return redisTemplate.opsForHash().entries(MESSAGE);
	}

	public boolean deleteMessage(String code) {
		return redisTemplate.opsForHash().delete(MESSAGE, code) != null;
	}
	
	public boolean updateMessage(String code, String newContent) {
	    if (redisTemplate.opsForHash().hasKey(MESSAGE, code)) {
	        redisTemplate.opsForHash().put(MESSAGE, code, newContent);
	        return true;
	    }
	    return false;
	}
}
