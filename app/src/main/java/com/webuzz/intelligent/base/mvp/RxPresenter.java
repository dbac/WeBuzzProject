package com.webuzz.intelligent.base.mvp;



public class RxPresenter<T extends BaseView, E extends BaseModel> implements BasePresenter<T> {
	private static final String TAG = "RxPresenter";
	protected T mView;
	protected E mModel;

	@Override
	public void attachView(T view) {
		mView = view;
	}

	@Override
	public void detachView() {
		mView = null;
	}


}
