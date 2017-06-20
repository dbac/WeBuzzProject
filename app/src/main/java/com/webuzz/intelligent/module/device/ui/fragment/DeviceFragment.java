package com.webuzz.intelligent.module.device.ui.fragment;


import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.webuzz.intelligent.R;
import com.webuzz.intelligent.base.mvp.BaseFragment;
import com.webuzz.intelligent.module.mine.adapter.MediaFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class DeviceFragment extends BaseFragment implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {

	@BindView(R.id.viewPager)
	ViewPager mPager;

	@BindView(R.id.radiogroup)
	RadioGroup mGroup;

	@BindView(R.id.minedevice)
	RadioButton minedevice;
	@BindView(R.id.arounddevice)
	RadioButton arounddevice;

	List<Fragment> fragmentList = new ArrayList<>();

	Fragment mineDeviceFragment = MineDeviceFragment.newInstance();
	Fragment aroundDeviceFragment = AroundDeviceFragment.newInstance();


	public DeviceFragment() {
		fragmentList.add(mineDeviceFragment);
		fragmentList.add(aroundDeviceFragment);
	}


	public static DeviceFragment newInstance() {
		DeviceFragment fragment = new DeviceFragment();
		return fragment;
	}


	@Override
	protected void initEvent() {
		super.initEvent();
		mGroup.setOnCheckedChangeListener(this);
		mPager.addOnPageChangeListener(this);
	}

	@Override
	protected void initData() {
		super.initData();
		mPager.setAdapter(new MediaFragmentPagerAdapter(getActivity().getSupportFragmentManager(), fragmentList));

	}

	@Override
	protected int getLayoutId() {
		return R.layout.fragment_device;
	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

	}

	@Override
	public void onPageSelected(int position) {
		switch (position) {
			case 0:
				mGroup.check(R.id.minedevice);
				break;
			case 1:
				mGroup.check(R.id.arounddevice);
				break;

		}
	}

	@Override
	public void onPageScrollStateChanged(int state) {

	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
			case R.id.minedevice:
				mPager.setCurrentItem(0);
				break;
			case R.id.arounddevice:
				mPager.setCurrentItem(1);
				break;
			default:
				break;
		}
	}
}
