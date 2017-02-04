package com.fxc.busline.busline.views;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fxc.busline.R;
import com.fxc.busline.base.BaseActivity;
import com.fxc.busline.busline.BusLineDownAdapter;
import com.fxc.busline.busline.beans.BusLinesBean;
import com.fxc.busline.busline.beans.BusOperatingTimeBean;
import com.fxc.busline.busline.BusLineUpAdapter;
import com.fxc.busline.busline.BusLineContract;
import com.fxc.busline.busline.presenter.MyBusPresent;
import com.fxc.busline.utils.API;
import com.fxc.busline.utils.Constant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BusLineDetailActivity extends BaseActivity implements BusLineContract.BusView {

	private Toolbar mToolbar;
	private NestedScrollView scrollView;
	private RecyclerView mRecyclerView;
	private CollapsingToolbarLayout mCollapsingToolbarLayout;
	private TextView tvBusSum;
	private TextView tvBusSpace;
	private RelativeLayout infoDetailsView;
	private TextView tvCanCard;
	private TextView tvFirstStation;
	private TextView tvLastStation;
	private TextView tvBusTicketValue;
	private TextView tvBusFirstTime;
	private TextView tvBusLastTime;
	private Button mBtExchange;

	private BusLineContract.BusPresenter mPresenter;

	private List mDatas;

	/**
	 * 公交路线
	 */
	private String mBusLineName;
	/**
	 * 公交路线代号
	 */
	private String mBusLineCode;

	private Intent mIntent;

	private BusLineUpAdapter mUpAdapter;
	private BusLineDownAdapter mDownAdapter;

	@Override
	protected void loadContentView() {
		setContentView(R.layout.activity_bus_lines);
	}

	@Override
	protected void initView() {
		mPresenter = new MyBusPresent(this);
		mRecyclerView = (RecyclerView) findViewById(R.id.main_vp_container);
		initToolBar();
		mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
		infoDetailsView = (RelativeLayout) findViewById(R.id.bus_line_info);
		tvBusSum = (TextView) infoDetailsView.findViewById(R.id.bus_line_bus_sum);
		tvBusSpace = (TextView) infoDetailsView.findViewById(R.id.bus_line_bus_space);
		tvCanCard = (TextView) infoDetailsView.findViewById(R.id.bus_line_tv_can_card);
		tvFirstStation = (TextView) infoDetailsView.findViewById(R.id.bus_line_tv_start);
		tvLastStation = (TextView) infoDetailsView.findViewById(R.id.bus_line_tv_end);
		tvBusTicketValue = (TextView) infoDetailsView.findViewById(R.id.bus_line_tv_ticket_value);
		tvBusFirstTime = (TextView) infoDetailsView.findViewById(R.id.bus_line_tv_first);
		tvBusLastTime = (TextView) infoDetailsView.findViewById(R.id.bus_line_tv_last);
		mBtExchange = (Button) mToolbar.findViewById(R.id.btnRight);
	}

	@Override
	protected void initData() {
		initIntentData();
		requestBusLineData();
		//获取公交路线
		// requestGetData(API.BUS_LINE_NUM_URL + API.BUS_LINE_NUM_BUS_LINE_NAME + 600);
	}

	private void requestBusLineData() {
		mPresenter.requestPostData(this, API.BUS_LINE_DETAILS_URL, getPostParams());
	}

	private void initIntentData() {
		mIntent = getIntent();
		mBusLineCode = mIntent.getStringExtra(Constant.BUS_LINE_CODE_KEY);
		mBusLineName = mIntent.getStringExtra(Constant.BUS_LINE_NUM_KEY);
		Log.d("poiu", mBusLineCode);
	}

	private void requestGetData(String url) {
		mPresenter.requestGetData(this, url);
	}

	@Override
	public void recyclerDataChange() {
		mUpAdapter = new BusLineUpAdapter(Constant.mBusLinesBean.getUp(), BusLineDetailActivity.this);
		mDownAdapter = new BusLineDownAdapter(Constant.mBusLinesBean.getDown(), BusLineDetailActivity.this);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(BusLineDetailActivity.this));
		if (Constant.isUp) {
			mRecyclerView.setAdapter(mUpAdapter);
		} else {
			mRecyclerView.setAdapter(mDownAdapter);
		}
	}

	@Override
	public void setBusLineDetailsView(BusLinesBean busLinesBean) {
		if (Constant.isUp) {
			String mFirstStationName = busLinesBean.getUp().get(0).getStation_name();
			String mLastStationName = busLinesBean.getUp().get(busLinesBean.getUp().size() - 1).getStation_name();
			if (mFirstStationName.length() > 5) {
				mFirstStationName = mFirstStationName.substring(0, 4) + "...";
			}
			if (mLastStationName.length() > 5) {
				mLastStationName = mLastStationName.substring(0, 4) + "...";
			}
			tvFirstStation.setText(mFirstStationName);
			tvLastStation.setText(mLastStationName);
		} else {
			String mFirstStationName = busLinesBean.getDown().get(0).getStation_name();
			String mLastStationName = busLinesBean.getDown().get(busLinesBean.getDown().size() - 1).getStation_name();
			if (mFirstStationName.length() > 5) {
				mFirstStationName = mFirstStationName.substring(0, 4) + "...";
			}
			if (mLastStationName.length() > 5) {
				mLastStationName = mLastStationName.substring(0, 4) + "...";
			}
			tvFirstStation.setText(mFirstStationName);
			tvLastStation.setText(mLastStationName);
		}

		// 在跑的车辆
		tvBusSum.setText(String.valueOf(busLinesBean.getRun_nums()));
		// 发车间隔
		String busSpace = busLinesBean.getAvg_interval() + getResources().getString(R.string.unit);
		tvBusSpace.setText(busSpace);
		if (busLinesBean.isIsSwipe()) {
			tvCanCard.setVisibility(View.VISIBLE);
		} else {
			tvCanCard.setVisibility(View.INVISIBLE);
		}
	}

	@Override
	public void setBusTicket(BusOperatingTimeBean bean) {
		mCollapsingToolbarLayout.setTitle(mBusLineName);
		String first = bean.getFSTSENDTIME().substring(11, bean.getFSTSENDTIME().length());
		String last = bean.getLSTSENDTIME().substring(11, bean.getLSTSENDTIME().length());
		tvBusTicketValue.setText(String.valueOf(bean.getNORMALVALUE()));
		tvBusFirstTime.setText(first);
		tvBusLastTime.setText(last);
	}

	private void initToolBar() {
		mToolbar = (Toolbar) findViewById(R.id.bus_line_toolbar);
		setSupportActionBar(mToolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onBackPressed();
			}
		});
	}


	public Map<String,String> getPostParams() {
		Map<String, String> mPostParams = new HashMap<>();
		mPostParams.put(API.BUS_LINE_DETAILS_TOKEN_KEY, API.BUS_LINE_DETAILS_TOKEN_VALUE);
		mPostParams.put(API.BUS_LINE_DETAILS_BUS_NUM_KEY, mBusLineCode);
		return mPostParams;
	}

	@Override
	protected void initListener() {
		mBtExchange.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (Constant.isUp) {
					Constant.isUp = false;
					mRecyclerView.setAdapter(mDownAdapter);
				} else {
					Constant.isUp = true;
					mRecyclerView.setAdapter(mUpAdapter);
				}
				if (Constant.isUp) {
					tvFirstStation.setText(Constant.mBusLinesBean.getUp().get(0).getStation_name());
					tvLastStation.setText(Constant.mBusLinesBean.getUp().get(Constant.mBusLinesBean.getUp().size() - 1).getStation_name());
				} else {
					tvFirstStation.setText(Constant.mBusLinesBean.getDown().get(0).getStation_name());
					tvLastStation.setText(Constant.mBusLinesBean.getDown().get(Constant.mBusLinesBean.getDown().size() - 1).getStation_name());
				}
			}
		});
	}
}
