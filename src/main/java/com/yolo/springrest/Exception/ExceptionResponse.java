package com.yolo.springrest.Exception;

import java.util.Date;

public class ExceptionResponse {
	
	private Date timeStamp;
	private String errMsg;
	private String details;
	
	public ExceptionResponse(Date timeStamp, String errMsg, String details) {
		super();
		this.timeStamp = timeStamp;
		this.errMsg = errMsg;
		this.details = details;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "GenericExceptionHandling [timeStamp=" + timeStamp + ", errMsg=" + errMsg + ", details=" + details + "]";
	}
	
}
