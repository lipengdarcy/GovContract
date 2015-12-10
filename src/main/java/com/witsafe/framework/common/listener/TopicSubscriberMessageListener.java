package com.witsafe.framework.common.listener;

//JMS消费者端（实现messageListener接口）
import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class TopicSubscriberMessageListener implements MessageListener {
	
	public void onMessage(Message msg) {
		System.out.println(new Date() + "==========接收到一个纯文本消息。");
		if (msg instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) msg;
			try {
				System.out.println("--订阅者 MessageListener收到信息："
						+ textMessage.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
}