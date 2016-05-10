package com.hzresp.commons.thread;

import java.util.List;

import com.shangban.thread.object.BpThreadDO;

/**
 * 线程状态同步数据库操作
 * @author robin
 *
 */
public interface BpThreadDao {

	public List<BpThreadDO> getBpThreads() ;

	public BpThreadDO get(String tid) ;

	public BpThreadDO get(int ddid) ;

	public long insert(BpThreadDO bpDO) ;

	public int update(BpThreadDO bpDO) ;

	public int updateForStatus(BpThreadDO bpDO) ;

	public int delete(BpThreadDO bpDO) ;

}