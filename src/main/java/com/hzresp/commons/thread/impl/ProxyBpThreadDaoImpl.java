package com.hzresp.commons.thread.impl;

import java.util.List;

import com.shangban.thread.BpThreadDao;
import com.shangban.thread.ProxyBpThreadDao;
import com.shangban.thread.object.BpThreadDO;
import com.shangban.thread.object.impl.DefaultBpThreadDO;

public class ProxyBpThreadDaoImpl implements ProxyBpThreadDao {

	private BpThreadDao bpDao;

	public void setBpDao(BpThreadDao bpDao) {
		this.bpDao = bpDao;
	}

	@Override
	public List<BpThreadDO> getList() {
		return bpDao.getBpThreads();
	}

	@Override
	public BpThreadDO getBpThreadDO(String tid) {
		BpThreadDO ddo = bpDao.get(tid);
		return ddo == null ? new DefaultBpThreadDO() : ddo;
	}

	@Override
	public BpThreadDO getBpThreadDO(int ddid) {
		return bpDao.get(ddid);
	}

	@Override
	public void stopRunThread(BpThreadDO bpThreadDO) {
		bpThreadDO.setStopBpThread();
		bpDao.updateForStatus(bpThreadDO);
	}

	@Override
	public boolean runThread(BpThreadDO bpThreadDO) {
		boolean result = false;
		bpThreadDO.setRunBpThread();
		if (null == bpDao.get(bpThreadDO.getTid())) {
			bpDao.insert(bpThreadDO);
			result = true;
		} else {
			int status = bpDao.updateForStatus(bpThreadDO);
			result = status != 0;
		}
		return result;
	}

	@Override
	public void deleteThread(BpThreadDO bpThreadDO) {
		bpThreadDO.setOverBpThread();
		bpDao.updateForStatus(bpThreadDO);
	}

}
