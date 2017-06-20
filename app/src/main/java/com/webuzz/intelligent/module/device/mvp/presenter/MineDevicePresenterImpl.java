package com.webuzz.intelligent.module.device.mvp.presenter;


import com.webuzz.intelligent.base.mvp.RxPresenter;
import com.webuzz.intelligent.module.device.bean.DeviceInfo;
import com.webuzz.intelligent.module.device.mvp.contract.MineDeviceContract;
import com.webuzz.intelligent.module.device.mvp.model.MineDeviceModelImpl;

import java.util.ArrayList;
import java.util.List;


public class MineDevicePresenterImpl extends RxPresenter<MineDeviceContract.View, MineDeviceContract.Model> implements
		MineDeviceContract.Presenter<MineDeviceContract.View> {

	public MineDevicePresenterImpl() {
		mModel = new MineDeviceModelImpl();
	}


	@Override
	public void loadData() {

		List<DeviceInfo> deviceInfos = new ArrayList<>();
		deviceInfos.add(new DeviceInfo("33", "未激活", "99%"));
		deviceInfos.add(new DeviceInfo("99", "已激活", "99%"));
		deviceInfos.add(new DeviceInfo("66", "已激活", "36%"));
		mView.showRecyclerView(deviceInfos);

	}


	@Override
	public void detachView() {
		super.detachView();
	}
}