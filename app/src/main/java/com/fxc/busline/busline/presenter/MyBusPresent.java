package com.fxc.busline.busline.presenter;

import android.content.Context;

import com.fxc.busline.busline.beans.BusLinesBean;
import com.fxc.busline.busline.beans.BusOperatingTimeBean;
import com.fxc.busline.busline.BusLineContract;
import com.fxc.busline.busline.model.MyBusModel;

import java.util.List;
import java.util.Map;

/**
 * Description :
 * Author   : fxc
 * Blog     : http://fxcdev.com
 * Date     : 2017/1/26.
 */

public class MyBusPresent implements BusLineContract.BusPresenter {

	private BusLineContract.BusView mBusView;
	private BusLineContract.BusModel mBusModel;

	public MyBusPresent(BusLineContract.BusView mBusView) {
		this.mBusView = mBusView;
		this.mBusModel = new MyBusModel(this);
	}

	@Override
	public void requestPostData(Context context, String url, Map<String, String> params) {
		mBusModel.requestPostData(context, url, params);
	}

	@Override
	public void requestGetData(Context context, String url) {
		mBusModel.requestBusNumData(context, url);
	}

	@Override
	public void setRecyclerViewData() {
		mBusView.recyclerDataChange();
	}

	@Override
	public void setBusLineDetailView(BusLinesBean beans) {
		mBusView.setBusLineDetailsView(beans);
	}

	@Override
	public void setBusTicket(BusOperatingTimeBean bean) {
		mBusView.setBusTicket(bean);
	}

	@Override
	public void requestBusTicketData(Context context, String url) {

	}

}
