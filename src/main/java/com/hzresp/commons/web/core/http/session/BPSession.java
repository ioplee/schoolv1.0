package com.hzresp.commons.web.core.http.session;

import com.shangban.exception.SessionException;
import com.shangban.exception.SessionTimeOutException;

/**
 * 商伴科技的session管理接口
 * @author steven blue
 *
 */
public interface BPSession {

	void setAttribute(String key, Object value) throws SessionException, SessionTimeOutException;

	void removeAttribute(String key) throws SessionException, SessionTimeOutException ;

	Object getAttribute(String key) throws SessionException, SessionTimeOutException ;

	void invalidate() throws SessionException, SessionTimeOutException ;
}
