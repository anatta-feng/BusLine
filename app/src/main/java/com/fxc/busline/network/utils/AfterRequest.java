package com.fxc.busline.network.utils;

import com.android.volley.VolleyError;

/**
 * Description :
 * Author   : fxc
 * Blog     : http://fxcdev.com
 * Date     : 2017/1/25.
 */

public interface AfterRequest {
	void success(String result);

	void error(VolleyError error);
}
