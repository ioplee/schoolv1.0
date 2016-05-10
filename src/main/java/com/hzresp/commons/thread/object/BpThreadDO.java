package com.hzresp.commons.thread.object;

/**
 * 线程框架的单个线程DO，先简单提供一些设置标志、获取状态，获取预设时间，停止运行，启动的方法。
 * @author robin
 *
 */
public interface BpThreadDO {

	public String getTid() ;
	public void setTid(String Tid) ;
	public int getStatus() ;

	/**
	 * 标记是哪个类型的线程，初始化的时候依据这个构造
	 * @return
	 */
	public String getThreadClassType() ;
	public String getRunIP() ;

	/**
	 * 运行、暂停状态都是可运行状态。
	 * @return
	 */
	public boolean isRuning();
	public boolean isRuning(String runIP);
	public void setStopBpThread() ;
	public void setRunBpThread() ;
	public void setOverBpThread() ;
}