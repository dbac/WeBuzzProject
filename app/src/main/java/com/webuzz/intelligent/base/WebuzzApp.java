package com.webuzz.intelligent.base;

import android.content.Context;

import com.webuzz.intelligent.base.mvp.CommonApplication;

/**
 * @name ${WeBuzz}
 * @anthor ${WFC}  itjavawfc@163.com
 * @time 2017/6/19 00:43
 * @class describe
 */
public class WebuzzApp extends CommonApplication {
	private static Context mContext;
	private static WebuzzApp app;

	public static WebuzzApp getInstance() {
		return app;
	}

	public static Context getContext() {
		return mContext;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		mContext = this;
		app = this;

		// RxPaparazzo.register(this);

	}


}
