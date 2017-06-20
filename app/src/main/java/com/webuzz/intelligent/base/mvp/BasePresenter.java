package com.webuzz.intelligent.base.mvp;

/**
 * @name ${WeBuzz}
 * @anthor ${WFC}  itjavawfc@163.com
 * @time 2017/6/19 00:52
 * @class describe
 */
public interface BasePresenter<T extends BaseView> {

	void attachView(T view);

	void detachView();

}
