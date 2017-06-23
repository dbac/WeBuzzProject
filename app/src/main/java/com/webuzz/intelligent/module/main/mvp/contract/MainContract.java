package com.webuzz.intelligent.module.main.mvp.contract;

import android.content.Context;
import android.support.design.widget.TabLayout;

import com.webuzz.intelligent.base.mvp.BaseModel;
import com.webuzz.intelligent.base.mvp.BasePresenter;
import com.webuzz.intelligent.base.mvp.BaseView;
import com.webuzz.intelligent.module.main.mvp.model.Recommend;

import java.util.List;

import io.reactivex.Observable;


/**
 * @name ${WeBuzz}
 * @anthor ${WFC}  itjavawfc@163.com
 * @time 2017/6/19 00:43
 * @class describe
 */
public class MainContract {

	public interface View extends BaseView {

		void connectBluetooth();

		void disConnectBluetooth();


	}

	public interface Presenter<T extends BaseView> extends BasePresenter<T> {

		void login(Context context);

		void setCustomViewData(TabLayout mTabLayout);


	}

	public interface Model extends BaseModel {

		Observable<List<Recommend>> getRecommend(String action);


	}

}