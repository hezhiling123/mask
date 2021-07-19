package cn.hezhiling.mask.label.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author hezhiling
 * @date 2021/7/1 11:38
 * @since V1.0
 */
@Component
@Slf4j
public class KafkaListener {
	@org.springframework.kafka.annotation.KafkaListener(topics = "TEST_TOPIC")
	public void handle(String message) {
		log.info(message);
	}
}
