package com.hzresp.commons.result;

import java.io.Serializable;

/**
 * @ClassName: ActionResult
 * @Description: action层向页面返回的信息(原商品通用的返回)
 * @author robin
 * @date 2013-11-20 上午11:27:04
 */
public class ActionResult implements Serializable {

	private static final long serialVersionUID = 161389017990134747L;

	// 操作结果标志
	private boolean success;

	// 返回信息
	private String msg;

	// service层返回对象
	private Object dataObject;

	// 消息code
	private String msgCode;

	public Object getDataObject() {
		return dataObject;
	}

	public void setDataObject(Object dataObject) {
		this.dataObject = dataObject;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public ActionResult(boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}

	public ActionResult() {
		super();
	}

	public String getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}

	public ActionResult toSuccess(Object dataObject) {
		this.success = true;
		this.dataObject = dataObject;
		return this;
	}

	public ActionResult toFail(String msg) {
		this.success = false;
		this.msg = msg;
		return this;
	}

	public ActionResult toFail(String msgCode, String msg) {
		this.success = false;
		this.msgCode = msgCode;
		this.msg = msg;
		return this;
	}
}
