package com.webuzz.intelligent.base.mvp;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.miguelbcr.ui.rx_paparazzo2.RxPaparazzo;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.tencent.bugly.crashreport.CrashReport;

public class CommonApplication extends MultiDexApplication {

	@Override
	public void onCreate() {
		super.onCreate();
	}


	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);
		MultiDex.install(this);
		Logger.addLogAdapter(new AndroidLogAdapter());
		CrashReport.initCrashReport(this, "fe252738ca", true);
		FlowManager.init(this);
 		RxPaparazzo.register(this);



	}
}
