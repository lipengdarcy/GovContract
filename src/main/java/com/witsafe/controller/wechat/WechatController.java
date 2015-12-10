package com.witsafe.controller.wechat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.witsafe.framework.wechat.WechatProcess;

/**
 * 微信服务端收发消息接口
 * 
 */

@Controller
@RequestMapping("/wechat")
public class WechatController {

	@ResponseBody
	@RequestMapping(value = "/answer")
	public String answer(String xml, String echostr) {
		/** 读取接收到的xml消息 */
		String result = "";
		/** 判断是否是微信接入激活验证，只有首次接入验证时才会收到echostr参数，此时需要把它直接返回 */
		if (echostr != null && echostr.length() > 1) {
			result = echostr;
		} else {
			// 正常的微信处理流程
			result = new WechatProcess().processWechatMag(xml);
		}
		return result;

	}

}
