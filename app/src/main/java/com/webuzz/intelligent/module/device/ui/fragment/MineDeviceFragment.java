package com.webuzz.intelligent.module.device.ui.fragment;


import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.webuzz.intelligent.R;
import com.webuzz.intelligent.base.WebuzzApp;
import com.webuzz.intelligent.base.mvp.BaseItemFragment;
import com.webuzz.intelligent.module.device.adapter.MineDeviceAdapter;
import com.webuzz.intelligent.module.device.bean.DeviceInfo;
import com.webuzz.intelligent.module.device.mvp.contract.MineDeviceContract;
import com.webuzz.intelligent.module.device.mvp.presenter.MineDevicePresenterImpl;

import java.util.List;

import butterknife.BindView;

public class MineDeviceFragment extends BaseItemFragment<MineDevicePresenterImpl> implements MineDeviceContract.View {

	@BindView(R.id.minedevices)
	RecyclerView mineDevicesView;

	MineDeviceAdapter mAdapter;

	public static MineDeviceFragment newInstance() {
		MineDeviceFragment fragment = new MineDeviceFragment();
		return fragment;
	}


	@Override
	protected void init() {
		super.init();
		mAdapter = new MineDeviceAdapter();
	}


	@Override
	protected MineDevicePresenterImpl initPresenter() {
		return new MineDevicePresenterImpl();
	}


	@Override
	protected void initData() {
		super.initData();
		getPresenter().loadData();
	}

	@Override
	protected void initView(View view) {
		super.initView(view);
		initRecyclerView();

	}


	private void initRecyclerView() {
		mineDevicesView.setLayoutManager(new LinearLayoutManager(WebuzzApp.getContext()));
		mineDevicesView.setItemAnimator(new DefaultItemAnimator());
		mineDevicesView.setAdapter(mAdapter);
	}


	@Override
	protected int getLayoutId() {
		return R.layout.fragment_minedevice;
	}

	@Override
	public void showRecyclerView(List<DeviceInfo> smartReminds) {
		mAdapter.setData(smartReminds);
		mAdapter.notifyDataSetChanged();

	}

	@Override
	public void showProgressView() {

	}

	@Override
	public void showEmptyView() {

	}

	@Override
	public void showErrorView() {

	}
}
