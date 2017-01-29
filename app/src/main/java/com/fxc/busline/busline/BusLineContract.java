package com.fxc.busline.busline;

import android.content.Context;

import com.fxc.busline.busline.beans.BusLinesBean;
import com.fxc.busline.busline.beans.BusOperatingTimeBean;

import java.util.List;
import java.util.Map;

/**
 * Description :
 * Author   : fxc
 * Blog     : http://fxcdev.com
 * Date     : 2017/1/26.
 */

public class BusLineContract {
	public interface BusView {

		void recyclerDataChange();

		void setBusLineDetailsView(BusLinesBean bean);

		void setBusTicket(BusOperatingTimeBean bean);
	}

	public interface BusModel {
		void requestPostData(Context context, String url, Map<String, String> params);

		void requestBusNumData(Context context, String url);

		void requestBusTicketData(Context context, String url);
	}

	public interface BusPresenter {
		void requestPostData(Context context, String url, Map<String, String> params);

		void requestGetData(Context context, String url);

		void setRecyclerViewData();

		void setBusLineDetailView(BusLinesBean bean);

		void setBusTicket(BusOperatingTimeBean bean);

		void requestBusTicketData(Context context, String url);
	}
}
