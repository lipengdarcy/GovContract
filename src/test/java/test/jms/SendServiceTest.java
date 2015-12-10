package test.jms;

import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class SendServiceTest {
	
	@Autowired
	@Qualifier(value="jmsTemplate")
	private JmsTemplate sendTemplate;

	

	public void sendMessage(final String message) {
		MessageCreator messageCreator = new MessageCreator() {
			public Message createMessage(Session session) {
				TextMessage msg = null;
				try {
					msg = session.createTextMessage(message);// 消息正文
					msg.setStringProperty("mykey", "ALL_GOODS_CHANGED_MESSAGE");// 定制消息头
				} catch (Exception e) {
				}
				return msg;
			}
		};
		sendTemplate.send(messageCreator);
	}

}