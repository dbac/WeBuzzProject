package com.webuzz.intelligent.base.mvp;


import rx.Observable;

/**
 * @name ${WeBuzz}
 * @anthor ${WFC}  itjavawfc@163.com
 * @time 2017/6/19 00:48
 * @class describe
 */
public interface BaseModel {
	<T> Observable<T> getData();
}
