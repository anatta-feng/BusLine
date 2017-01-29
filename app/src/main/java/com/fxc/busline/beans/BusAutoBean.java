package com.fxc.busline.beans;

/**
 * Description :	通过输入框的内容联想搜索路线，注：该类需在数组中使用
 * 					List.add(new BusAutoBean())
 * Author   : fxc
 * Blog     : http://fxcdev.com
 * Date     : 2017/1/26.
 */

public class BusAutoBean extends BaseBean {

	/**
	 * ROUTEID : 117
	 * ROUTENAME : 6路
	 * COMPARELINEID : 5944
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
