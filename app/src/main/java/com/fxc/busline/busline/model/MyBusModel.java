package com.fxc.busline.busline.model;

import android.content.Context;
import android.util.Log;

import com.android.volley.VolleyError;
import com.fxc.busline.busline.beans.BusLinesBean;
import com.fxc.busline.beans.BusNumBean;
import com.fxc.busline.busline.beans.BusOperatingTimeBean;
import com.fxc.busline.busline.BusLineContract;
import com.fxc.busline.network.utils.AfterRequest;
import com.fxc.busline.network.utils.NetworkUtil;
import com.fxc.busline.network.utils.json.GsonUtil;
import com.fxc.busline.utils.API;
import com.fxc.busline.utils.Constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Description :
 * Author   : fxc
 * Blog     : http://fxcdev.com
 * Date     : 2017/1/26.
 */

public class MyBusModel implements BusLineContract.BusModel {
	private BusLineContract.BusPresenter mPresenter;
	private Map<String, String> postParams;

	public MyBusModel(BusLineContract.BusPresenter mPresenter) {
		this.mPresenter = mPresenter;
	}

	@Override
	public void requestPostData(final Context context, String url, Map<String, String> params) {
		AfterRequest mPostRequest = new AfterRequest() {
			@Override
			public void success(String result) {
				Log.d("qwe", result);
				Constant.mBusLinesBean = (BusLinesBean) GsonUtil.setObjectGson(result, BusLinesBean.class);

				Log.d("qwer", result);
				mPresenter.setRecyclerViewData();
				mPresenter.setBusLineDetailView(Constant.mBusLinesBean);
				requestBusTicketData(context, API.BUS_LINE_TICKET_URL + API.BUS_LINE_TICKET_SEGMENT_ID + Constant.mBusLinesBean.getUp().get(0).getRunning_type());
			}

			@Override
			public void error(VolleyError error) {
				Log.d("qwer", error.toString());
			}
		};

		NetworkUtil.newInstance(context).sendPostRequest(url, params, mPostRequest);
	}

	@Override
	public void requestBusNumData(final Context context, final String url) {
		AfterRequest mGetRequest = new AfterRequest() {
			@Override
			public void success(String result) {
				Log.d("asd", result);
				Log.d("asd", url);
				Constant.mBusNumBean = GsonUtil.setArrayGson(result, BusNumBean[].class);
			}

			@Override
			public void error(VolleyError error) {

			}
		};

		NetworkUtil.newInstance(context).sendGetRequest(url, mGetRequest);
	}

	@Override
	public void requestBusTicketData(Context context, String url) {
		AfterRequest mGetRequest = new AfterRequest() {
			@Override
			public void success(String result) {
				Constant.mBusOperatingTimeBean = (BusOperatingTimeBean) GsonUtil.setObjectGson(result, BusOperatingTimeBean.class);

				mPresenter.setBusTicket(Constant.mBusOperatingTimeBean);
			}

			@Override
			public void error(VolleyError error) {

			}
		};
		NetworkUtil.newInstance(context).sendGetRequest(url, mGetRequest);
	}

}
