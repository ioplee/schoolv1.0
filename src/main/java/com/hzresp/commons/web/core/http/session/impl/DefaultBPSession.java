package com.hzresp.commons.web.core.http.session.impl;

import javax.servlet.http.HttpServletRequest;

import com.shangban.exception.SessionException;
import com.shangban.exception.SessionTimeOutException;
import com.shangban.web.core.http.session.BPSession;

/**
 * 默认实现，原生session的封装
 * 
 * @author LiYishi
 */
public class DefaultBPSession implements BPSession {

	private HttpServletRequest request;

	public DefaultBPSession(){
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setAttribute(String key, Object value) throws SessionException, SessionTimeOutException {
		this.request.getSession().setAttribute(key, value);
	}

	@Override
	public void removeAttribute(String key) throws SessionException, SessionTimeOutException {
		this.request.getSession().removeAttribute(key);
	}

	@Override
	public Object getAttribute(String key) throws SessionException, SessionTimeOutException {
		return this.request.getAttribute(key);
	}

	@Override
	public void invalidate() throws SessionException, SessionTimeOutException {
		this.request.getSession().invalidate();
	}

}
