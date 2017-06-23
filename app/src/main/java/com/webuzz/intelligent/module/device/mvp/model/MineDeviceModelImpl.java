package com.webuzz.intelligent.module.device.mvp.model;


import com.webuzz.intelligent.module.device.mvp.contract.MineDeviceContract;

import io.reactivex.Observable;


public class MineDeviceModelImpl implements MineDeviceContract.Model {

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