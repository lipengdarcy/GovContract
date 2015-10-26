package com.witsafe.contracts.entity.common;

public class ResponseData {
	private Integer code = 0;
	private String state;
	private String content;

	public ResponseData(String statusCode, String content) {
		this.state = statusCode;
		this.content = content;
	}

	public ResponseData(String content) {
		this.state = "success";
		this.content = content;
	}
	public ResponseData() {

	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	

}
