package com.webuzz.intelligent.module.main.mvp.model;

import com.webuzz.intelligent.module.main.mvp.contract.MainContract;

import java.util.List;

import io.reactivex.Observable;


/**
 * @name ${WeBuzz}
 * @anthor ${WFC}  itjavawfc@163.com
 * @time 2017/6/19 00:42
 * @class describe
 */
public class MainModelImpl implements MainContract.Model {

	@Override
	public <T> Observable<T> getData() {
		return null;
	}


	@Override
	public Observable<List<Recommend>> getRecommend(String action) {
		return null;
	}
}