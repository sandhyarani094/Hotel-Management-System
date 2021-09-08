package com.bipro.model;

public class Response {
	private String responseValue;

	public String getResponseValue() {
		return responseValue;
	}

	public void setResponseValue(String responseValue) {
		this.responseValue = responseValue;
	}

	@Override
	public String toString() {
		return "Response [responseValue=" + responseValue + "]";
	}

	public Response(String responseValue) {
		super();
		this.responseValue = responseValue;
	}

	public Response() {
		super();
		
	}
	
	
	

}
