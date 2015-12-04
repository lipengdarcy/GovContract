
package com.witsafe.service.jms;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

 @Service("messageListener")
public class ReceiveMessageListener implements MessageListener {  
   public ReceiveMessageListener(){
	   System.out.println("ReceiveMessageListener...");
   }
   
    private static final Logger LOG = Logger.getLogger(ReceiveMessageListener.class);  
      
    public void onMessage(Message message) {  
        if (message instanceof TextMessage) {  
            TextMessage text = (TextMessage) message;  
            try {  
                System.out.println("Received message:" + text.getText()+this);  
            } catch (JMSException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
  
}  