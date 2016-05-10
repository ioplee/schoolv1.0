package com.hzresp.commons.thread;

import java.util.Date;

import com.shangban.thread.object.BpThreadResultDO;


/**
 * 代表了一个BP的业务实例
 * @author robin
 *
 */
public interface BpExecutor {

	/**
	 * 该线程类型的唯一标示，一个常驻线程只允许在一台机器上执行
	 * @return
	 */
	public String getTid() ;

	/**
	 * 线程是否可终止，通常销毁线程时会先调用此方法询问，为true时调用销毁方法，并移除队列
	 * 注意：强制移除时不会关注此状态。
	 * @return
	 */
	public boolean isCanStop() ;

	/**
	 * 线程遇到异常情况时销毁线程前调用该方法进行备份，亦可主动调用此方法进行备份和暂停线程。
	 * 该状态由实现方进行维护
	 */
	public void backStatus() ;

	/**
	 * 线程重新启动时，会先复盘状态，该状态交由接口实现方去考虑维护。
	 */
	public void setStatus() ;

	/**
	 * 此状态表明是否常驻线程(即不可强制销毁的线程，只能伴随着异常终止而终止)
	 * @return
	 */
	public boolean isWhileRun() ;

	/**
	 * 线程调度间隔，默认500ms,单位ms
	 * @return
	 */
	public int whileTime() ;

	/**
	 * 设置定时运行的时间
	 * @return
	 */
	public Date prerunStart() ;

	/**
	 * 当线程执行后，得到一个result关注接口，实现方可通过此接口关注线程的执行过程，
	 * 当完成时可主动通知实现方，异常时亦可主动通知业务方
	 * @return
	 */
	public BpThreadResultDO execute() ;
}
