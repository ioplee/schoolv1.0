package com.hzresp.commons.thread.object.impl;

import com.shangban.thread.object.BpThreadDO;
import com.shangban.utils.StringUtil;

public class DefaultBpThreadDO implements BpThreadDO {

	private String tid ;
	private int status ;
	private String runIP ;
	private String threadClassType ;

	@Override
	public String getTid() {
		return this.tid;
	}

	@Override
	public void setTid(String tid) {
		this.tid = tid ;
	}

	@Override
	public int getStatus() {
		return this.status ;
	}

	@Override
	public String getRunIP() {
		return this.runIP ;
	}

	public void setRunIP(String runIP) {
		this.runIP = runIP ;
	}

	@Override
	public boolean isRuning() {
		return this.status == 0 || this.status == 1 || this.status == 2;
	}

	@Override
	public void setStopBpThread() {
		this.status = 2 ;
	}

	@Override
	public void setRunBpThread() {
		this.status = 1 ;
	}

	@Override
	public void setOverBpThread() {
		this.status = 3 ;
	}

	@Override
	public boolean isRuning(String runIP) {
		if (StringUtil.isEmptyString(runIP)) {
			return false ;
		}
		if (null == this.runIP) {
			return true ;
		}
		if (null != this.runIP && this.runIP.equals(runIP)) {
			return this.status == 1 || this.status == 0;
		}
		return false;
	}

	@Override
	public String getThreadClassType() {
		return this.threadClassType;
	}

	public void setThreadClassType(String threadClassType) {
		this.threadClassType = threadClassType ;
	}

}