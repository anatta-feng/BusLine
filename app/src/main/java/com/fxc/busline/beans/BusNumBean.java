package com.fxc.busline.beans;

/**
 * Description :	根据公交路线获取其代号
 * Author   : fxc
 * Blog     : http://fxcdev.com
 * Date     : 2017/1/26.
 */

public class BusNumBean extends BaseBean {


	/**
	 * ROUTEID : 132
	 * ROUTENAME : 600路
	 * COMPARELINEID : 3343
	 */

	private String ROUTEID;
	private String ROUTENAME;
	private String COMPARELINEID;

	public String getROUTEID() {
		return ROUTEID;
	}

	public void setROUTEID(String ROUTEID) {
		this.ROUTEID = ROUTEID;
	}

	public String getROUTENAME() {
		return ROUTENAME;
	}

	public void setROUTENAME(String ROUTENAME) {
		this.ROUTENAME = ROUTENAME;
	}

	public String getCOMPARELINEID() {
		return COMPARELINEID;
	}

	public void setCOMPARELINEID(String COMPARELINEID) {
		this.COMPARELINEID = COMPARELINEID;
	}
}
