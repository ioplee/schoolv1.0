package com.hzresp.commons.thread.impl;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.shangban.thread.BpThreadDao;
import com.shangban.thread.object.BpThreadDO;

public class SingleBpThreadDao implements BpThreadDao {

	private Map<String, BpThreadDO> threads = new Hashtable<String, BpThreadDO>();

	public SingleBpThreadDao(){
	}

	@Override
	public BpThreadDO get(String tid) {
		return threads.get(tid);
	}

	@Override
	public BpThreadDO get(int ddid) {
		return null;
	}

	@Override
	public long insert(BpThreadDO bpDO) {
		if (threads.containsKey(bpDO.getTid())) return 0;

		threads.put(bpDO.getTid(), bpDO);
		return 1;
	}

	@Override
	public int update(BpThreadDO bpDO) {
		if (threads.containsKey(bpDO.getTid())) {
			threads.put(bpDO.getTid(), bpDO);
			return 1;
		}
		return 0;
	}

	@Override
	public int updateForStatus(BpThreadDO bpDO) {
		if (threads.containsKey(bpDO.getTid())) {
			BpThreadDO src = threads.get(bpDO.getTid());
			if (src.isRuning(bpDO.getRunIP())) {
				threads.put(src.getTid(), bpDO);
				return 1;
			} else if (!src.isRuning()) {
				threads.put(src.getTid(), bpDO);
			}
		}
		return 0;
	}

	@Override
	public int delete(BpThreadDO bpDO) {
		return 0;
	}

	@Override
	public List<BpThreadDO> getBpThreads() {
		Set<String> keys = threads.keySet();
		Iterator<String> i = keys.iterator();
		List<BpThreadDO> bps = new ArrayList<BpThreadDO>();
		while (i.hasNext()) {
			bps.add(threads.get(i.next()));
		}
		return bps;
	}

}
