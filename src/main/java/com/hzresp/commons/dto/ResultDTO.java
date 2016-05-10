package com.hzresp.commons.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: ResultDTO
 * @Description: 当对象返回
 * @author robin
 * @date 2014-2-25 下午5:32:06
 */
public class ResultDTO<T> extends BaseResultDTO {

	private static final long serialVersionUID = -1654503515179180525L;

	protected T module;

	// 保存详细的校验错误信息
	protected Map<String, String> checkErrorInfo = new HashMap<String, String>();

	public ResultDTO() {
	}

	public ResultDTO(T module) {
		this.module = module;
	}

	public T getModule() {
		return module;
	}

	public void setModule(T module) {
		this.module = module;
	}

	public void addCheckErrorInfo(String code, String message) {
		checkErrorInfo.put(code, message);
	}

	public void addCheckErrorInfos(Map<String, String> infos) {
		checkErrorInfo.putAll(infos);
	}

	public Map<String, String> getCheckErrorInfo() {
		return checkErrorInfo;
	}

	public static <T> ResultDTO<T> getResult() {
		return new ResultDTO<T>();
	}

	public boolean isExist() {
		return null != module;
	}

}
