package com.fxc.busline.homepager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.fxc.busline.R;
import com.fxc.busline.beans.BusNumBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Description :
 * Author   : fxc
 * Blog     : http://fxcdev.com
 * Date     : 2017/1/28.
 */

public class MyAdapter extends BaseAdapter implements Filterable {

	private Context mContext;
	private List<BusNumBean> mDataList;
	private ArrayList<BusNumBean> mUnFilterData;
	private ArrayFilter mFilter;

	public MyAdapter(Context mContext, List<BusNumBean> mDataList) {
		this.mContext = mContext;
		this.mDataList = mDataList;
	}

	@Override
	public int getCount() {
		return mDataList.size();
	}

	@Override
	public Object getItem(int position) {
		return mDataList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View mView;
		ViewHolder mHolder;
		if (convertView == null) {
			mView = LayoutInflater.from(mContext).inflate(R.layout.auto_text_view, parent, false);
			mHolder = new ViewHolder();
			mHolder.textView = (TextView) mView.findViewById(R.id.auto_textview);
			mView.setTag(mHolder);
		} else {
			mView = convertView;
			mHolder = (ViewHolder) mView.getTag();
		}

		BusNumBean bean = mDataList.get(position);
		mHolder.textView.setText(bean.getROUTENAME());
		return mView;
	}

	static class ViewHolder {
		public TextView textView;
	}

	@Override
	public Filter getFilter() {
		if (mFilter == null) {
			mFilter = new ArrayFilter();
		}
		return mFilter;
	}

	private class ArrayFilter extends Filter {

		@Override
		protected FilterResults performFiltering(CharSequence prefix) {
			FilterResults results = new FilterResults();

			if (mUnFilterData == null) {
				mUnFilterData = new ArrayList<>(mDataList);
			}
			if (prefix == null || prefix.length() == 0) {
				ArrayList<BusNumBean> list = mUnFilterData;
				results.values = list;
				results.count = list.size();
			} else {
				String prefixString = prefix.toString().toLowerCase();

				ArrayList<BusNumBean> unfilteredValues = mUnFilterData;
				int count = unfilteredValues.size();
				ArrayList<BusNumBean> newValues = new ArrayList<>(count);

				for (int i = 0; i < count; i++) {
					BusNumBean bean = unfilteredValues.get(i);
					String valueText = bean.getROUTENAME();
//					if (valueText.startsWith(prefixString)) {
//						newValues.add(bean);
//					} else {
//						String[] words = valueText.split(" ");
//						for (String word : words) {
//							if (word.startsWith(prefixString)) {
//								newValues.add(bean);
//								break;
//							}
//						}
//					}

					if (bean != null) {

						if (valueText.startsWith(prefixString)) {
							newValues.add(bean);
						} else {
							String[] words = valueText.split(" ");
							for (String word : words) {
								if (word.startsWith(prefixString)) {
									newValues.add(bean);
									break;
								}
							}
						}
					}
				}
				results.values = newValues;
				results.count = newValues.size();
			}
			return results;
		}

		@Override
		protected void publishResults(CharSequence constraint, FilterResults results) {
			mDataList = (List<BusNumBean>) results.values;
			if (results.count > 0) {
				notifyDataSetChanged();
			} else {
				notifyDataSetInvalidated();
			}
		}
	}
}
