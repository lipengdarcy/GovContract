package com.witsafe.controller.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.witsafe.service.jms.MessageSender;

@Controller
@RequestMapping("/jms")
public class SendMessageController {  

    @Autowired
    private MessageSender messageSender;  
    
    @RequestMapping()
	public String load(ModelMap m) {
		return "jms/index";
	}
  
    @RequestMapping("/sendMessage")
    public String sendMessage(String message, ModelMap m
            ) throws Exception {  

        messageSender.sendMessage(message);  
        m.put("message", message) ;
        return "jms/success";  
    }  
  
  
   
  
}  
