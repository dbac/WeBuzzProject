package com.webuzz.intelligent.base.mvp;

import android.content.Context;
import android.os.Bundle;

/**
 * @name ${WeBuzz}
 * @anthor ${WFC}  itjavawfc@163.com
 * @time 2017/6/19 00:47
 * @class describe
 */
public abstract class BaseItemFragment<T extends BasePresenter> extends BaseFragment<T> {
	private static final String TAG = "BaseItemFragment";
	public Context mContext;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getActivity() != null)
			mContext = getActivity();
	}
}