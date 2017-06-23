package com.webuzz.intelligent.module.mine.mvp.model;


import com.webuzz.intelligent.module.mine.mvp.contract.MineFragmentContract;

import io.reactivex.Observable;


public class MineFragmentModelImpl implements MineFragmentContract.Model {

	@Override
	public void saveData() {

	}


	@Override
	public void getDataFromDb() {

	}

	@Override
	public <T> Observable<T> getData() {
		return null;
	}
}