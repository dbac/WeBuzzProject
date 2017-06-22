package com.webuzz.intelligent.base.mvp;

import android.content.Context;
import android.view.View;


public abstract class BaseHolder<T> {

	public View mHolderView;
	protected Context mContext;
	private T mData;

	public BaseHolder(Context context) {
		mContext = context;
		mHolderView = initHolderView(context);
	}

	protected abstract View initHolderView(Context context);

	public void setDataAndRefreshHolderView(T data) {
		mData = data;
		refreshHolderView(data);
	}

	protected abstract void refreshHolderView(T data);

}
