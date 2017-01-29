package com.fxc.busline.network.utils.json;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

/**
 * Description :
 * Author   : fxc
 * Blog     : http://fxcdev.com
 * Date     : 2017/1/25.
 */

public class GsonUtil {

	public static Object setObjectGson(String s, Class clazz) {
		Gson gson = new Gson();
		return gson.fromJson(s, clazz);
	}

	public static <T> List<T> setArrayGson(String s, Class<T[]> clazz) {
		Gson gson = new Gson();
		T[] array = gson.fromJson(s, clazz);
		return Arrays.asList(array);
	}

}
