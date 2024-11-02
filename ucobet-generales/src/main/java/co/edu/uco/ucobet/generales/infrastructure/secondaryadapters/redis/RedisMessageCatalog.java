package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import co.edu.uco.ucobet.generales.crosscutting.messagecatalog.MessageCatalog;

@Component
public class RedisMessageCatalog implements MessageCatalog {

	private static final String MESSAGE_COUNTER_KEY = "messageCounter";

	private final RedisTemplate<String, String> redisTemplate;

	public RedisMessageCatalog(RedisTemplate<String, String> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public String getMessage(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	public void addMessage(String code, String messageContent) {
	    redisTemplate.opsForHash().put("messages", code, messageContent);
	}

	public String generateNextMessageCode() {
		Long counter = redisTemplate.opsForValue().increment(MESSAGE_COUNTER_KEY);
		return String.format("M%05d", counter); // Formato M00001, M00002, etc.
	}

}
