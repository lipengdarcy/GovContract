package com.witsafe.service.jms;

/*
 * @(#) MessageSender.java
 * @Author:Administrator(mail) 2013-10-2
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service("messageSender")
public class MessageSender {
	
	public MessageSender() {
		System.out.println("messageSender is constructor...");
	}

	private static final Logger LOG = Logger.getLogger(MessageSender.class);
	
	@Resource
	private JmsTemplate jmsTemplate;

	public void sendMessage(final String message) {
		System.out.println("Send message: " + message);
		jmsTemplate.send(new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage = session.createTextMessage(message);
				return textMessage;
			}

		});
	}
}
