package com.fxc.busline.utils;

/**
 * Description :
 * Author   : fxc
 * Blog     : http://fxcdev.com
 * Date     : 2017/1/26.
 */

public class API {
	public static final String BUS_LINE_DETAILS_URL = "http://www.xaglkp.com.cn/Bus/GetRealBusLine";
	public static final String BUS_LINE_DETAILS_TOKEN_KEY = "__RequestVerificationToken";
	public static final String BUS_LINE_DETAILS_TOKEN_VALUE =
			"Jsh5_yuEuscmEVLg0pm_Cw-R" +
					"-q_zfp0sutbzkbjMCrBoPFB1fhSMIDJsSaE4kIckrjhpnvhL90NWGRsbBXMXsR9BIaZP6ulYXdAg9hTVYT01";
	public static final String BUS_LINE_DETAILS_BUS_NUM_KEY = "routeid";

	public static final String BUS_LINE_NUM_URL = "http://www.xaglkp.com.cn/Bus/GetBusLineByName";
	public static final String BUS_LINE_NUM_BUS_LINE_NAME = "?buslinename=";



	/**
	 * 查询票价已经运行时间
	 */
	public static final String BUS_LINE_TICKET_URL = "http://www.xaglkp.com.cn/Bus/GetBusLineInfoBySegmentId";
	public static final String BUS_LINE_TICKET_SEGMENT_ID = "?segmentId=";
}
