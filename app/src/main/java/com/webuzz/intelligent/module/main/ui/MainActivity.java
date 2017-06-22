package com.webuzz.intelligent.module.main.ui;

import android.Manifest;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;

import com.webuzz.intelligent.R;
import com.webuzz.intelligent.base.mvp.BaseActivity;
import com.webuzz.intelligent.module.main.adapter.MainTableAdapter;
import com.webuzz.intelligent.module.main.mvp.contract.MainContract;
import com.webuzz.intelligent.module.main.mvp.presenter.MainPresenterImpl;

import butterknife.BindView;
import es.dmoral.toasty.Toasty;


/**
 * @name ${WeBuzz}
 * @anthor ${WFC}  itjavawfc@163.com
 * @time 2017/6/19 00:43
 * @class describe
 */
public class MainActivity extends BaseActivity<MainPresenterImpl> implements MainContract.View {

	@BindView(R.id.tablayout)
	TabLayout mTabLayout;
	@BindView(R.id.mainpager)
	ViewPager mPager;
	private long exitTime = 0;


	@Override
	protected void init() {
		super.init();
	}


	@Override
	protected void initData() {
		super.initData();
	}

	@Override
	protected void initView() {
		super.initView();
		mPager.setAdapter(new MainTableAdapter(getSupportFragmentManager()));
		mPager.setOffscreenPageLimit(4);
		mTabLayout.setupWithViewPager(mPager);
		getPresenter().setCustomViewData(mTabLayout);
		mTabLayout.getTabAt(0).select();

	}

	@Override
	protected MainPresenterImpl initPresenter() {
		return new MainPresenterImpl();
	}



	@Override
	public int getLayoutId() {
		return R.layout.activity_main;

	}


	@Override
	public void connectBluetooth() {

	}

	@Override
	public void disConnectBluetooth() {

	}


	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
			case KeyEvent.KEYCODE_BACK: {
				if ((System.currentTimeMillis() - exitTime) > 2000) {
					Drawable drawable = getResources().getDrawable(R.mipmap.webuzz_back);
					Toasty.normal(this, "再按一次退出WeBuzz！", 1000, drawable).show();
					exitTime = System.currentTimeMillis();
				} else {
					finish();
				}
			}
			break;
		}
		return false;
	}

}
