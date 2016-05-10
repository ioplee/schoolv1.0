package com.hzresp.commons.thread.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shangban.thread.BpExecutor;
import com.shangban.thread.BpExecutorResult;
import com.shangban.thread.BpThreadManager;
import com.shangban.thread.ProxyBpThreadDao;
import com.shangban.thread.constant.ThreadConstant;
import com.shangban.thread.object.BpThreadDO;
import com.shangban.thread.object.BpThreadResultDO;
import com.shangban.thread.object.impl.DefaultBpThreadDO;
import com.shangban.utils.StringUtil;

public class DefaultProxyBpExecutor implements BpExecutor, BpExecutorResult, Runnable {

    private Logger log = LoggerFactory.getLogger(ThreadConstant.THREAD_LOG_NAME);

    private BpExecutor bpExecute;
    private ProxyBpThreadDao bpThreadDao;
    private BpThreadManager bpThreadManager;

    private String ip;

    public DefaultProxyBpExecutor(){
    }

    public DefaultProxyBpExecutor(BpExecutor bpexecute){
        this.bpExecute = bpexecute;
    }

    public void setBpExecutor(BpExecutor bpExecute) {
        this.bpExecute = bpExecute;
    }

    public void setBpThreadDao(ProxyBpThreadDao bpThreadDao) {
        this.bpThreadDao = bpThreadDao;
    }

    public void setBpThreadManager(BpThreadManager bpThreadManager) {
        this.bpThreadManager = bpThreadManager;
    }

    @Override
    public String getTid() {
        return this.bpExecute.getTid();
    }

    @Override
    public boolean isCanStop() {
        return this.bpExecute.isCanStop();
    }

    @Override
    public void backStatus() {
        this.bpExecute.backStatus();
    }

    @Override
    public void setStatus() {
        this.bpExecute.setStatus();
    }

    @Override
    public boolean isWhileRun() {
        return this.bpExecute.isWhileRun();
    }

    @Override
    public int whileTime() {
        int whileTime = this.bpExecute.whileTime();
        return whileTime != 0 ? whileTime : 500;
    }

    @Override
    public Date prerunStart() {
        return this.bpExecute.prerunStart();
    }

    @Override
    public BpThreadResultDO execute() {
        BpThreadResultDO result = this.bpExecute.execute();
        callback(bpExecute, result);
        callback(result, result);

        return result;
    }

    @Override
    public void run() {
        // TODO 添加需要添加的逻辑
        BpThreadDO ddo = null;
        BpThreadResultDO resultDO = null;

        try {
            if (StringUtil.isEmptyString(ip)) {
                try {
                    this.ip = InetAddress.getLocalHost().getHostAddress();
                    log.debug("ip of the thread running is :" + this.getTid() + ",threadId:"
                              + Thread.currentThread().getId());
                } catch (UnknownHostException e1) {
                    // log记录下cao
                    log.error("unknownHost:", e1);
                }
            }
            ddo = bpThreadDao.getBpThreadDO(this.getTid());
            boolean init = initBpThreadDO(ddo, this.getTid());

            if (!ddo.isRuning(this.ip)) {
                bpThreadManager.removeDrpExe(this.bpExecute);
                log.info("remove thread:" + this.getTid() + ",threadId:" + Thread.currentThread().getId());
                return;
            }

            if (ddo.isRuning() || (init && bpThreadDao.runThread(ddo))) {
                log.debug("run thread:" + this.getTid() + ",threadId:" + Thread.currentThread().getId());
                resultDO = this.execute();
            } else {
                // 当线程没启动时记录
                log.info("thread:" + this.getTid() + " not run");
                log.info("thread is running:" + ddo.isRuning() + ",init:" + init + ",drpThreadDao.runThread:"
                         + bpThreadDao.runThread(ddo));
            }
        } catch (Exception e) {
            log.error("thread " + this.getTid() + " run error:", e);
        } finally {
            callback(this, resultDO);
        }
    }

    @Override
    public void callback(BpThreadResultDO t) {
        if (t == null) return;
        BpThreadDO ddo = new DefaultBpThreadDO();
        ddo.setTid(t.getTid());

        if (!this.isWhileRun()) {
            // remove 在线程池中移除自己
            bpThreadDao.deleteThread(ddo);
            bpThreadManager.removeDrpExe(this);
        } else {
            bpThreadDao.stopRunThread(ddo);
        }
    }

    @Override
    public boolean isCallback() {
        return true;
    }

    private void callback(Object o, BpThreadResultDO threadResult) {
        if (o instanceof BpExecutorResult) {
            BpExecutorResult result = ((BpExecutorResult) o);
            if (result.isCallback()) {
                result.callback(threadResult);
            }
        }
    }

    public boolean initBpThreadDO(BpThreadDO ddo, String tid) {
        if (null != ddo) {
            return true;
        }
        ddo = new DefaultBpThreadDO();
        ddo.setTid(this.getTid());

        return false;
    }
}
