package com.hzresp.commons.thread.object.impl;

import com.shangban.thread.object.BpThreadResultDO;

/**
 *
 *@author 作者:robin
 *@date 创建时间:2013-9-23下午11:41:27
 */
public class DefaultBpResultDO implements BpThreadResultDO{
	
	private String tid;
	
	public DefaultBpResultDO(String tid) {
		this.tid = tid;
	}
	
	@Override
	public String getTid() {
		return tid;
	}

}
