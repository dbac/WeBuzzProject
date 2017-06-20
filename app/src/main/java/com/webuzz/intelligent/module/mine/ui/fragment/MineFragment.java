package com.webuzz.intelligent.module.mine.ui.fragment;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import com.webuzz.intelligent.R;
import com.webuzz.intelligent.base.WebuzzApp;
import com.webuzz.intelligent.base.mvp.BaseItemFragment;
import com.webuzz.intelligent.module.mine.adapter.MineFragmentAdapter;
import com.webuzz.intelligent.module.mine.bean.ScoreCategory;
import com.webuzz.intelligent.module.mine.mvp.contract.MineFragmentContract;
import com.webuzz.intelligent.module.mine.mvp.presenter.MineFragmentPresenterImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;


public class MineFragment extends BaseItemFragment<MineFragmentPresenterImpl> implements MineFragmentContract.View {

	private static final String ARG_PARAM1 = "param1";
	private static final String ARG_PARAM2 = "param2";

	@BindView(R.id.scorecategory)
	RecyclerView scoreCategoryView;
	@BindView(R.id.rlminehistory)
	RelativeLayout rlminehistory;
	@BindView(R.id.rlsetting)
	RelativeLayout rlsetting;
	@BindView(R.id.rlabout)
	RelativeLayout rlabout;

	MineFragmentAdapter mAdapter;

	@BindView(R.id.toolbar)
	Toolbar toolbar;


	private String mParam1;
	private String mParam2;


	public MineFragment() {
	}

	public static MineFragment newInstance() {
		MineFragment fragment = new MineFragment();
		return fragment;
	}

	@Override
	protected void init() {
		mAdapter = new MineFragmentAdapter();
	}

	@Override
	protected void initView(View view) {
		initRecyclerView();
		initToolBar();
	}

	@Override
	protected MineFragmentPresenterImpl initPresenter() {
		return new MineFragmentPresenterImpl();
	}

	@Override
	protected void initData() {
		getPresenter().loadData();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			mParam1 = getArguments().getString(ARG_PARAM1);
			mParam2 = getArguments().getString(ARG_PARAM2);
		}
	}


	private void initRecyclerView() {
		scoreCategoryView.setLayoutManager(new GridLayoutManager(WebuzzApp.getContext(), 4));
		scoreCategoryView.setItemAnimator(new DefaultItemAnimator());
		scoreCategoryView.setAdapter(mAdapter);
	}

	@Override
	protected int getLayoutId() {
		return R.layout.fragment_mine;
	}


	@Override
	public void showRecyclerView(List<ScoreCategory> smartReminds) {
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

	private void initToolBar() {
		toolbar.setTitle(getString(R.string.mine));
		((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

	}

	@OnClick({R.id.rlminehistory, R.id.rlsetting, R.id.rlabout})
	void butterknifeOnClick(View view) {
		switch (view.getId()) {
			case R.id.rlminehistory:
				Toasty.normal(WebuzzApp.getContext(), "历史记录！", 0).show();
				break;
			case R.id.rlsetting:
				Toasty.normal(WebuzzApp.getContext(), "设置！", 0).show();
				break;
			case R.id.rlabout:
				Toasty.normal(WebuzzApp.getContext(), "关于！", 0).show();
				break;
		}
	}
}