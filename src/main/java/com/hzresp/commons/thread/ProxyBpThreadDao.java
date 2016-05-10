package com.hzresp.commons.thread;

import java.util.List;

import com.shangban.thread.object.BpThreadDO;

public interface ProxyBpThreadDao {

    public List<BpThreadDO> getList();

    public BpThreadDO getBpThreadDO(String tid);

    public BpThreadDO getBpThreadDO(int ddid);

    /**
     * 如果线程存在并且状态为运行中，则终止运行
     * 
     * @param bpThreadDO
     */
    public void stopRunThread(BpThreadDO bpThreadDO);

    /**
     * 立即启动线程，如果线程不存在，则新增，如果线程存在，则更新状态。<br />
     * 当实际执行sql成功，影响1条记录时，返回true，否则返回false <br />
     * 跟数据库的匹配条件是tid相等且runIP相等，方可运行本线程。 <br />
     * 
     * @param bpThreadDO
     */
    public boolean runThread(BpThreadDO bpThreadDO);

    /**
     * 删除线程。不需要等待执行完成，如果非常驻线程，则物理删除改线程记录
     * 
     * @param bpThreadDO
     */
    public void deleteThread(BpThreadDO bpThreadDO);
}
