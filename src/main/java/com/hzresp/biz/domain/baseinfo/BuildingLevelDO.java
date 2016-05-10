/**   
* @Title: BuildingLevelDO.java 
* @Package com.hzresp.biz.domain.baseinfo 
* @Description: TODO(用一句话描述该文件做什么) 
* @author robin
* @date 2016年5月10日 下午5:58:04 
* @version V1.0   
*/
package com.hzresp.biz.domain.baseinfo;

/** 
 * @ClassName: BuildingLevelDO 
 * @Description: 楼层实体bean
 * @author robin
 * @date 2016年5月10日 下午5:58:04 
 *  
 */
public class BuildingLevelDO {
	/** The level_no. */
	private long levelNo;
	
	/** The building_no. */
	private long buildingNo;
	
	/** The memo. */
	private String memo;
	
	/** The level_status. */
	private String levelStatus;
	
	/** The customer_no. */
	private String customerNo;

	/**
	 * @return the levelNo
	 */
	public long getLevelNo() {
		return levelNo;
	}

	/**
	 * @param levelNo the levelNo to set
	 */
	public void setLevelNo(long levelNo) {
		this.levelNo = levelNo;
	}

	/**
	 * @return the buildingNo
	 */
	public long getBuildingNo() {
		return buildingNo;
	}

	/**
	 * @param buildingNo the buildingNo to set
	 */
	public void setBuildingNo(long buildingNo) {
		this.buildingNo = buildingNo;
	}

	/**
	 * @return the memo
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * @param memo the memo to set
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * @return the levelStatus
	 */
	public String getLevelStatus() {
		return levelStatus;
	}

	/**
	 * @param levelStatus the levelStatus to set
	 */
	public void setLevelStatus(String levelStatus) {
		this.levelStatus = levelStatus;
	}

	/**
	 * @return the customerNo
	 */
	public String getCustomerNo() {
		return customerNo;
	}

	/**
	 * @param customerNo the customerNo to set
	 */
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

}
