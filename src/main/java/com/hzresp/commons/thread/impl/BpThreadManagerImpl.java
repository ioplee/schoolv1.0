package com.hzresp.commons.thread.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shangban.thread.BpExecuteCreator;
import com.shangban.thread.BpExecutor;
import com.shangban.thread.BpThreadManager;
import com.shangban.thread.ProxyBpThreadDao;
import com.shangban.thread.constant.ThreadConstant;
import com.shangban.thread.object.BpThreadDO;
import com.shangban.thread.object.impl.DefaultBpThreadDO;

public class BpThreadManagerImpl implements BpThreadManager {

	private Logger log = LoggerFactory.getLogger(ThreadConstant.THREAD_LOG_NAME);

	// 线程延迟启动时间
	private int threadDelayTime = ThreadConstant.DEF_T_R_DELAY;

	// 线程队列
	private Map<String, BpExecuteCreator> bpExecuteCreateMap;

	// 威力强大的线程池，可以用他来做调度控制，不过目前只是使用它来完成线程运行得管理。以它做线线程调度的实现后期会补充上去
	private ScheduledThreadPoolExecutor threadPool = new ScheduledThreadPoolExecutor(100);
	private ProxyBpThreadDao bpThreadDao;

	public void init() {
		List<BpThreadDO> bpThreads = bpThreadDao.getList();
		if (null == bpThreads) return;

		for (BpThreadDO threadDo : bpThreads) {
			executeBpExe(threadDo.getTid(), threadDo.getThreadClassType());
		}
	}

	public void setBpExecuteCreateMap(Map<String, BpExecuteCreator> bpExecuteCreateMap) {
		this.bpExecuteCreateMap = bpExecuteCreateMap;
	}

	public void setBpThreadDao(ProxyBpThreadDao bpThreadDao) {
		this.bpThreadDao = bpThreadDao;
	}

	@Override
	public synchronized void executeBpExe(BpExecutor bpExecutor) {
		// TODO 保存所执行的线程tid，并初始化加入线程队列的状态
		if (bpExecutor.getTid().equals(bpThreadDao.getBpThreadDO(bpExecutor.getTid()).getTid())) {
			return;
		}
		DefaultProxyBpExecutor proxyExecute = new DefaultProxyBpExecutor(bpExecutor);

		proxyExecute.setBpThreadDao(bpThreadDao);
		proxyExecute.setBpThreadManager(this);

		BpThreadDO ddo = new DefaultBpThreadDO();
		ddo.setTid(bpExecutor.getTid());

		bpThreadDao.runThread(ddo);

		if (bpExecutor.isWhileRun()) {
			threadPool.scheduleWithFixedDelay(proxyExecute, threadDelayTime, proxyExecute.whileTime(), TimeUnit.MILLISECONDS);
		} else {
			threadPool.schedule(proxyExecute, threadDelayTime, TimeUnit.MILLISECONDS);
		}
		log.info("threadPoolSize:" + threadPool.getPoolSize() + ",threadSize:" + threadPool.getTaskCount() + ",threadActive:" + threadPool.getActiveCount());
	}

	@Override
	public void removeDrpExe(BpExecutor bpExecutor) {
		threadPool.remove((DefaultProxyBpExecutor) bpExecutor);
		log.info("remove BpExecutor tid:" + bpExecutor.getTid());
	}

	@Override
	public void executeBpExe(String tid, String type) {
		BpExecutor bpExecutor = bpExecuteCreateMap.get(type).creatorBpExecutor(tid);
		log.info("add thread:" + tid + ",type:" + type);
		executeBpExe(bpExecutor);
	}

	public void setThreadDelayTime(int threadDelayTime) {
		this.threadDelayTime = threadDelayTime;
	}
}
