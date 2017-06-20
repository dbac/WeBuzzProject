package com.webuzz.intelligent.base.mvp;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;


/**
 * @name ${WeBuzz}
 * @anthor ${WFC}  itjavawfc@163.com
 * @time 2017/6/19 01:39
 * @class describe
 */
public class CommonApplication extends MultiDexApplication {

	@Override
	public void onCreate() {
		super.onCreate();
	}


	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);
		MultiDex.install(this);
	}
}
