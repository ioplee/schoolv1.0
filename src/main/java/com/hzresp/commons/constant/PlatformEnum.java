package com.hzresp.commons.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: PlatformEnum
 * @Description: 平台枚举，后续待扩展
 * @author robin
 * @date 2016年3月29日 下午5:45:37
 *
 */
public enum PlatformEnum {
	/** 其他 */
	OTHER(0, "其他"),
	/** 天猫 */
	TMALL(1, "天猫"),
	/** 淘宝 */
	TAOBAO(2, "淘宝"),
	/** 京东 */
	JD(3, "京东"),
	/** 拍拍 */
	PAIPAI(4, "拍拍"),
	/** 1号店 */
	YHD(5, "1号店"),
	/** 苏宁 */
	SUNING(6, "苏宁"),
	/** 1号店 */
	@Deprecated
	YHD_OLD(7, "1号店"),
	/** 当当 */
	DANGDANG(8, "当当"),
	/** 飞牛 */
	FEINIU(9, "飞牛"),
	/** 美丽说 */
	MEILISHUO(10, "美丽说"),
	/** 麦考林 */
	MECOXLANE(11, "麦考林"),
	/** 亚马逊 */
	AMAZON(12, "亚马逊"),
	/** EBAY */
	EBAY(13, "EBAY"),
	/** 唯品会 */
	VIP(14, "唯品会"),
	/** 聚美优品 */
	JUMEI(15, "聚美优品"),
	/** 国美 */
	GOME(16, "国美"),
	/** 凡客 */
	VANCL(17, "凡客"),
	/** 丽子美妆 */
	LIZI(18, "丽子美妆"),
	/** 蘑菇街 */
	MOGUJIE(19, "蘑菇街"),
	/** i688--> 阿里1688 */
	I688(20, "1688"),
	/** 洽客 */
	QIAKR(21, "洽客"),

	/** 衣工厂，自有b2b，预留了88这个值 */
	YGC(88, "衣工厂");

	private static Map<Integer, PlatformEnum> enumMap = new HashMap<Integer, PlatformEnum>();

	static {
		PlatformEnum[] pes = PlatformEnum.values();
		for (PlatformEnum pe : pes) {
			enumMap.put(pe.getPlatformId(), pe);
		}
	}

	private int platformId;
	private String platformName;

	private PlatformEnum(int platformId, String platformName) {
		this.platformId = platformId;
		this.platformName = platformName;
	}

	public int getPlatformId() {
		return platformId;
	}

	public String getPlatformName() {
		return platformName;
	}

	public static String getPlatformNameById(int platformId) {
		return enumMap.get(platformId).getPlatformName();
	}

	public static PlatformEnum conByInt(int platformId) {
		return enumMap.get(platformId);
	}
}
