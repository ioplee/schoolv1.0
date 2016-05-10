package com.hzresp.commons.thread;

import com.shangban.thread.object.BpThreadResultDO;


/**
 * 每次线程执行完成之后回调的接口
 * @author robin
 *
 * @param <T>
 */
public interface BpExecutorResult {

	public void callback(BpThreadResultDO t) ;
	public boolean isCallback() ;
}
