package com.witsafe.framework.wechat;

//调用图灵机器人api接口，获取智能回复内容：

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

/**
 * 调用图灵机器人api接口，获取智能回复内容
 * 
 * @author pamchen-1
 *
 */
public class TulingApiProcess {
	/**
	 * 调用图灵机器人api接口，获取智能回复内容，解析获取自己所需结果
	 * 
	 * @param content
	 * @return
	 */

	// API地址:
	private String api_url = "http://www.tuling123.com/openapi/api";
	// API Key:
	private String api_key = "07f520e75f601dced765d3f17a3d88b9";

	public String getTulingResult(String content) {
		/** 此处为图灵api接口，参数key需要自己去注册申请，先以11111111代替 */
		String url = api_url + "?key=" + api_key  +  "&info=";
		//"http://www.tuling123.com/openapi/api?key=11111111&info=";
		String param = "";
		try {
			param = url + URLEncoder.encode(content, "utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // 将参数转为url编码
		/** 发送httpget请求 */
		HttpGet request = new HttpGet(param);
		String result = "";
		try {
			HttpResponse response = HttpClients.createDefault()
					.execute(request);
			if (response.getStatusLine().getStatusCode() == 200) {
				result = EntityUtils.toString(response.getEntity());
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/** 请求失败处理 */
		if (null == result) {
			return "对不起，你说的话真是太高深了……";
		}
		try {
			JSONObject json = JSONObject.parseObject(result);
			// 以code=100000为例，参考图灵机器人api文档
			if (100000 == json.getInteger("code")) {
				result = json.getString("text");
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}