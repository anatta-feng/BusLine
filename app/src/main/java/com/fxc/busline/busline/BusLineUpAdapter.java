package com.fxc.busline.busline;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fxc.busline.R;
import com.fxc.busline.busline.beans.BusLinesBean;

import java.util.List;

/**
 * Description :
 * Author   : fxc
 * Blog     : http://fxcdev.com
 * Date     : 2017/1/26.
 */

public class BusLineUpAdapter extends RecyclerView.Adapter<BusLineUpAdapter.MyViewHolder> {

	private List<BusLinesBean.UpBean> mDataList;
	private Context mContext;

	public BusLineUpAdapter(List<BusLinesBean.UpBean> mDataList, Context mContext) {
		this.mDataList = mDataList;
		this.mContext = mContext;
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		MyViewHolder mHolder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.recycler_view_list,
				parent, false));
		return mHolder;
	}

	@Override
	public void onBindViewHolder(MyViewHolder holder, int position) {
		// 设置站点名称
		String mStationName = position + 1 + ". " + mDataList.get(position).getStation_name();
		holder.tvStationName.setText(mStationName);
		// 设置是否有公交
		int busCount = mDataList.get(position).getBus_count();
		if (busCount == 0) {
			holder.tvBusNum.setVisibility(View.INVISIBLE);
			holder.ivBus.setVisibility(View.INVISIBLE);
			holder.ivHasBus.setImageResource(R.drawable.ic_bus_down_gray_24dp);
		} else {
			holder.ivBus.setVisibility(View.VISIBLE);
			holder.tvBusNum.setText(String.valueOf(busCount));
			holder.tvBusNum.setVisibility(View.VISIBLE);
			holder.ivHasBus.setImageResource(R.drawable.ic_bus_down_blue_24dp);
		}
		if (position == 0) {
			holder.ivHasBus.setImageResource(R.drawable.ic_bus_down_green_24dp);
		}
		if (position == mDataList.size() - 1) {
			holder.ivHasBus.setImageResource(R.drawable.ic_bus_down_red_24dp);
		}
	}

	@Override
	public int getItemCount() {
		return mDataList.size();
	}


	class MyViewHolder extends RecyclerView.ViewHolder {

		ImageView ivBus;
		TextView tvBusNum;
		ImageView ivHasBus;
		TextView tvStationName;

		public MyViewHolder(View view) {
			super(view);
			ivBus = (ImageView) view.findViewById(R.id.list_bus);
			tvBusNum = (TextView) view.findViewById(R.id.list_tv_bus_count);
			ivHasBus = (ImageView) view.findViewById(R.id.list_down);
			tvStationName = (TextView) view.findViewById(R.id.list_tv_station_name);
		}
	}
}
