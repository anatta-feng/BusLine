package com.fxc.busline.base;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Description :
 * Author   : fxc
 * Blog     : http://fxcdev.com
 * Date     : 2017/1/26.
 */

public abstract class BaseActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		loadContentView();
		initView();
		initData();
		initListener();
	}

	protected abstract void loadContentView();

	protected void initView() {

	}

	protected void initData() {

	}

	protected void initListener() {

	}

	protected void showToast(String text, int showTime) {
		Toast mToast = Toast.makeText(this, text, showTime);
		mToast.show();
	}

	protected void startAvtivity(Intent intent) {
		startActivity(intent);
	}

	protected void startServices(Intent intent) {

	}

	protected void showDialog(Context context, String text) {
		Dialog dialog = new AlertDialog.Builder(context).create();
		dialog.setTitle(text);
		 dialog.setCancelable(true);
	}
}
