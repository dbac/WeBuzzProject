package com.webuzz.intelligent.module.device.mvp.contract;


import com.webuzz.intelligent.base.mvp.BaseModel;
import com.webuzz.intelligent.base.mvp.BasePresenter;
import com.webuzz.intelligent.base.mvp.BaseView;
import com.webuzz.intelligent.module.device.bean.DeviceInfo;

import java.util.List;


public class MineDeviceContract {

	public interface View extends BaseView {
		void showRecyclerView(List<DeviceInfo> smartReminds);

		void showProgressView();

		void showEmptyView();

		void showErrorView();
	}

	public interface Presenter<T extends BaseView> extends BasePresenter<T> {
		void loadData();
	}

	public interface Model extends BaseModel {
		void saveData();

		void getDataFromDb();
	}


}