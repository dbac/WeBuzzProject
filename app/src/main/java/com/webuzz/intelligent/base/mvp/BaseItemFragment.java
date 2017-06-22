package com.webuzz.intelligent.base.mvp;

import android.content.Context;
import android.os.Bundle;

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