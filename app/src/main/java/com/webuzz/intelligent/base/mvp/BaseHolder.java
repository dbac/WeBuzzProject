package com.webuzz.intelligent.base.mvp;

import android.content.Context;
import android.view.View;

/**
 * @name ${WeBuzz}
 * @anthor ${WFC}  itjavawfc@163.com
 * @time 2017/6/19 00:46
 * @class describe
 */
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
