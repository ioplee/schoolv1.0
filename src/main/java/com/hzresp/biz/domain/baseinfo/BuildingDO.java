/**   
* @Title: BuildingDO.java 
* @Package com.hzresp.biz.domain.baseinfo 
* @Description: TODO(用一句话描述该文件做什么) 
* @author robin
* @date 2016年5月10日 下午5:54:53 
* @version V1.0   
*/
package com.hzresp.biz.domain.baseinfo;

/** 
 * @ClassName: BuildingDO 
 * @Description: 楼宇实体BEAN
 * @author robin
 * @date 2016年5月10日 下午5:54:53 
 *  
 */
public class BuildingDO {
	/** The building_no. */
	private long building_no;
	
	/** The building_name. */
	private String building_name;
	
	/** The customer_no. */
	private long customer_no;
	
	/** The memo. */
	private String memo;
	
	/** The building_status. */
	private String building_status;
	
	/** The gmt_create. */
	private String gmt_create;
	
	/** The gmt_modify. */
	private String gmt_modify;

	/**
	 * @return the building_no
	 */
	public long getBuilding_no() {
		return building_no;
	}

	/**
	 * @param building_no the building_no to set
	 */
	public void setBuilding_no(long building_no) {
		this.building_no = building_no;
	}

	/**
	 * @return the building_name
	 */
	public String getBuilding_name() {
		return building_name;
	}

	/**
	 * @param building_name the building_name to set
	 */
	public void setBuilding_name(String building_name) {
		this.building_name = building_name;
	}

	/**
	 * @return the customer_no
	 */
	public long getCustomer_no() {
		return customer_no;
	}

	/**
	 * @param customer_no the customer_no to set
	 */
	public void setCustomer_no(long customer_no) {
		this.customer_no = customer_no;
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
	 * @return the building_status
	 */
	public String getBuilding_status() {
		return building_status;
	}

	/**
	 * @param building_status the building_status to set
	 */
	public void setBuilding_status(String building_status) {
		this.building_status = building_status;
	}

	/**
	 * @return the gmt_create
	 */
	public String getGmt_create() {
		return gmt_create;
	}

	/**
	 * @param gmt_create the gmt_create to set
	 */
	public void setGmt_create(String gmt_create) {
		this.gmt_create = gmt_create;
	}

	/**
	 * @return the gmt_modify
	 */
	public String getGmt_modify() {
		return gmt_modify;
	}

	/**
	 * @param gmt_modify the gmt_modify to set
	 */
	public void setGmt_modify(String gmt_modify) {
		this.gmt_modify = gmt_modify;
	}
}
