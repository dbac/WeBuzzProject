package com.webuzz.intelligent.base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * @name ${WeBuzz}
 * @anthor ${WFC}  itjavawfc@163.com
 * @time 2017/6/19 00:45
 * @class describe
 */
public abstract class BaseFragment<T extends BasePresenter> extends SupportFragment implements BaseView {
	public View mRootView;
	private T mPresenter;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		init();
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		if (mRootView == null) {
			mRootView = inflater.inflate(getLayoutId(), container, false);
		}
		ButterKnife.bind(this, mRootView);
		mPresenter = initPresenter();
		return mRootView;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		initView(view);
		if (mPresenter != null) {
			mPresenter.attachView(this);
		}
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initData();
		initEvent();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		if (mPresenter != null) {
			mPresenter.detachView();
		}
	}

	protected void init() {
	}

	protected void initData() {

	}

	protected void initView(View view) {

	}

	protected T initPresenter() {
		return null;
	}

	protected void initEvent() {

	}



	@Override
	protected FragmentAnimator onCreateFragmentAnimator() {
		return new DefaultHorizontalAnimator();
	}

	protected abstract int getLayoutId();

	public T getPresenter() {
		return mPresenter;
	}

	protected SupportActivity getHoldingActivity() {
		return _mActivity;
	}

}
