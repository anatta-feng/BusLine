package com.fxc.busline.homepager;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.android.volley.VolleyError;
import com.fxc.busline.R;
import com.fxc.busline.base.BaseActivity;
import com.fxc.busline.beans.BusNumBean;
import com.fxc.busline.busline.views.BusLineDetailActivity;
import com.fxc.busline.network.utils.AfterRequest;
import com.fxc.busline.network.utils.NetworkUtil;
import com.fxc.busline.network.utils.json.GsonUtil;
import com.fxc.busline.utils.Constant;

import java.util.ArrayList;

/**
 * Description :
 * Author   : fxc
 * Blog     : http://fxcdev.com
 * Date     : 2017/1/28.
 */

public class MainActivity extends BaseActivity {

	private AutoCompleteTextView mEditText;
	private Button mSearch;
	private ArrayList<String> data;
	private ArrayAdapter adapter;
	private MyAdapter myAdapter;

	@Override
	protected void loadContentView() {
		setContentView(R.layout.activity_main);

	}

	@Override
	protected void initView() {
		mEditText = (AutoCompleteTextView) findViewById(R.id.main_ed_input);
		mSearch = (Button) findViewById(R.id.main_search);
	}

	@Override
	protected void initData() {
		data = new ArrayList<>();
		NetworkUtil.newInstance(this).sendGetRequest(API.BUS_LINE_NUM_URL + API.BUS_LINE_NUM_BUS_LINE_NAME, new
				AfterRequest() {

			@Override
			public void success(String result) {
				Log.d("poi", result);
				Constant.mBusNumBean = GsonUtil.setArrayGson(result, BusNumBean[].class);
				myAdapter = new MyAdapter(MainActivity.this, Constant.mBusNumBean);
				mEditText.setAdapter(myAdapter);
				myAdapter.notifyDataSetInvalidated();
			}

			@Override
			public void error(VolleyError error) {

			}
		});

	}

	@Override
	protected void initListener() {

		mEditText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				BusNumBean busNumBean = (BusNumBean) myAdapter.getItem(position);
				String busCode = busNumBean.getROUTEID();
				String busNum = busNumBean.getROUTENAME();
				busNum = busNum.replaceAll("[^0-9]", "");
				Intent mIntent = new Intent(MainActivity.this, BusLineDetailActivity.class);

				mIntent.putExtra(Constant.BUS_LINE_CODE_KEY, busCode);
				mIntent.putExtra(Constant.BUS_LINE_NUM_KEY, busNum);
				startActivity(mIntent);
				mEditText.setText("");
				Log.d("poi", busNumBean.getROUTEID());
			}
		});
	}

	public ArrayList<String> getData() {
		adapter.clear();
		for (int i = 0; i < Constant.mBusNumBean.size() - 1; i++) {
			adapter.add(Constant.mBusNumBean.get(i).getROUTENAME());
			adapter.notifyDataSetChanged();
		}
		Log.d("qaz", data.size() + "");
		return data;
	}
}
