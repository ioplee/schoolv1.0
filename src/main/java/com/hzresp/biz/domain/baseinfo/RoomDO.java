/**   
* @Title: RoomDO.java 
* @Package com.hzresp.biz.domain.baseinfo 
* @Description: TODO(用一句话描述该文件做什么) 
* @author robin
* @date 2016年5月10日 下午6:09:48 
* @version V1.0   
*/
package com.hzresp.biz.domain.baseinfo;

// TODO: Auto-generated Javadoc
/**
 *  
 *
 * @author robin
 * @ClassName: RoomDO
 * @Description: 房间实体BEAN
 * @date 2016年5月10日 下午6:09:48
 */
public class RoomDO {
	
	/** The room no. */
	private long roomNo;
	
	/** The building no. */
	private long buildingNo;
	
	/** The level no. */
	private long levelNo;
	
	/** The room name. */
	private String roomName;
	
	/** The memo. */
	private String memo;
	
	/** The room status. */
	private String roomStatus;
	
	/**
	 * Gets the room no.
	 *
	 * @return the roomNo
	 */
	public long getRoomNo() {
		return roomNo;
	}
	
	/**
	 * Sets the room no.
	 *
	 * @param roomNo the roomNo to set
	 */
	public void setRoomNo(long roomNo) {
		this.roomNo = roomNo;
	}
	
	/**
	 * Gets the building no.
	 *
	 * @return the buildingNo
	 */
	public long getBuildingNo() {
		return buildingNo;
	}
	
	/**
	 * Sets the building no.
	 *
	 * @param buildingNo the buildingNo to set
	 */
	public void setBuildingNo(long buildingNo) {
		this.buildingNo = buildingNo;
	}
	
	/**
	 * Gets the level no.
	 *
	 * @return the levelNo
	 */
	public long getLevelNo() {
		return levelNo;
	}
	
	/**
	 * Sets the level no.
	 *
	 * @param levelNo the levelNo to set
	 */
	public void setLevelNo(long levelNo) {
		this.levelNo = levelNo;
	}
	
	/**
	 * Gets the room name.
	 *
	 * @return the roomName
	 */
	public String getRoomName() {
		return roomName;
	}
	
	/**
	 * Sets the room name.
	 *
	 * @param roomName the roomName to set
	 */
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	/**
	 * Gets the memo.
	 *
	 * @return the memo
	 */
	public String getMemo() {
		return memo;
	}
	
	/**
	 * Sets the memo.
	 *
	 * @param memo the memo to set
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	/**
	 * Gets the room status.
	 *
	 * @return the roomStatus
	 */
	public String getRoomStatus() {
		return roomStatus;
	}
	
	/**
	 * Sets the room status.
	 *
	 * @param roomStatus the roomStatus to set
	 */
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
	

}
