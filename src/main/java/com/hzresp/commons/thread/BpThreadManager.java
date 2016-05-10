package com.hzresp.commons.thread;

public interface BpThreadManager {

	/**
	 * 一次性执行时，推荐使用该接口执行
	 * @param bpExecutor
	 */
	public void executeBpExe(BpExecutor bpExecutor) ;

	/**
	 * 配置推荐使用该接口
	 * @param tid
	 * @param type
	 */
	public void executeBpExe(String tid, String type) ;
	
	public void removeDrpExe(BpExecutor bpExecutor) ;
}
