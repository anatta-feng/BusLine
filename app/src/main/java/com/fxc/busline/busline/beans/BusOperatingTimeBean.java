package com.fxc.busline.busline.beans;

import com.fxc.busline.beans.BaseBean;

/**
 * Description :	获取公交运行时间以及票价
 * Author   : fxc
 * Blog     : http://fxcdev.com
 * Date     : 2017/1/26.
 */

public class BusOperatingTimeBean extends BaseBean {


	/**
	 * FSTSENDTIME : 2017-01-26 06:00:00
	 * LSTSENDTIME : 2017-01-26 23:00:00
	 * NORMALVALUE : 2.0
	 */

	private String FSTSENDTIME;
	private String LSTSENDTIME;
	private double NORMALVALUE;

	public String getFSTSENDTIME() {
		return FSTSENDTIME;
	}

	public void setFSTSENDTIME(String FSTSENDTIME) {
		this.FSTSENDTIME = FSTSENDTIME;
	}

	public String getLSTSENDTIME() {
		return LSTSENDTIME;
	}

	public void setLSTSENDTIME(String LSTSENDTIME) {
		this.LSTSENDTIME = LSTSENDTIME;
	}

	public double getNORMALVALUE() {
		return NORMALVALUE;
	}

	public void setNORMALVALUE(double NORMALVALUE) {
		this.NORMALVALUE = NORMALVALUE;
	}
}
