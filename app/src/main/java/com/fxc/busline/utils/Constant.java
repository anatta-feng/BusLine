package com.fxc.busline.utils;

import com.fxc.busline.beans.BusAutoBean;
import com.fxc.busline.busline.beans.BusLinesBean;
import com.fxc.busline.beans.BusNumBean;
import com.fxc.busline.busline.beans.BusOperatingTimeBean;

import java.util.List;

/**
 * Description :
 * Author   : fxc
 * Blog     : http://fxcdev.com
 * Date     : 2017/1/26.
 */

public class Constant {
	public static BusLinesBean mBusLinesBean;
	public static BusAutoBean mBusAutoBean;
	public static List<BusNumBean> mBusNumBean;
	public static BusOperatingTimeBean mBusOperatingTimeBean;

	/****** 交互协议--------start ******/
	/**
	 * 公交路线
	 */
	public static final String BUS_LINE_CODE_KEY = "busLine";
	/**
	 * 公交路线代号
	 */
	public static final String BUS_LINE_NUM_KEY = "busLineNum";
	/****** 交互协议--------end ********/

	// 如果是 isUp 则取 up 节点，否则取 down 节点
	public static boolean isUp = true;

	/****** Bean 传递协议--------start ******/
	public static final String BEAN_BUS_LINES = "busLinesBean";
	public static final String BEAN_BUS_NUM = "busNumBean";
	public static final String BEAN_BUS_AUTO = "busAutoBean";
	public static final String BEAN_BUS_OPERA = "busOperaBean";
	/****** Bean 传递协议--------end ********/
}
