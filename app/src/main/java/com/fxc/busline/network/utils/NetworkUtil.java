package com.fxc.busline.network.utils;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

/**
 * Description :
 * Author   : fxc
 * Blog     : http://fxcdev.com
 * Date     : 2017/1/25.
 */

public class NetworkUtil {
	private RequestQueue mQueue;
	private Context mContext;
	private static NetworkUtil mUtil;

	private NetworkUtil(Context mContext) {
		this.mContext = mContext;
	}

	public static NetworkUtil newInstance(Context context) {
		if (mUtil == null) {
			synchronized (NetworkUtil.class) {
				if (mUtil == null) {
					mUtil = new NetworkUtil(context);
				}
			}
		}
		return mUtil;
	}

	public RequestQueue getRequestQueue() {
		mQueue = Volley.newRequestQueue(mContext);
		return mQueue;
	}

	public void sendGetRequest(String url, final AfterRequest mInterface) {
		Response.Listener<String> mListener = new Response.Listener<String>() {
			@Override
			public void onResponse(String s) {
				mInterface.success(s);
			}
		};
		Response.ErrorListener mErrorListener = new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError volleyError) {
				mInterface.error(volleyError);
			}
		};
		StringRequest mRequest = new StringRequest(Request.Method.GET, url, mListener, mErrorListener);
		mQueue = getRequestQueue();
		mQueue.add(mRequest);
	}

	public void sendPostRequest(String url, final Map<String, String> params, final AfterRequest mInterface) {
		Response.Listener<String> mListener = new Response.Listener<String>() {
			@Override
			public void onResponse(String s) {
				mInterface.success(s);
			}
		};
		Response.ErrorListener mErrorListener = new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError volleyError) {
				mInterface.error(volleyError);
			}
		};
		StringRequest mRequest = new StringRequest(Request.Method.POST, url, mListener, mErrorListener) {
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				return params;
			}
		};
		mRequest.setShouldCache(false);
		mQueue = getRequestQueue();
		mQueue.add(mRequest);
	}
}
