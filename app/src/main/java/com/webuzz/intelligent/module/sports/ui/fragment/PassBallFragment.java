package com.webuzz.intelligent.module.sports.ui.fragment;


import com.webuzz.intelligent.R;
import com.webuzz.intelligent.base.mvp.BaseFragment;

public class PassBallFragment extends BaseFragment {

	public static PassBallFragment newInstance() {
		PassBallFragment fragment = new PassBallFragment();
		return fragment;
	}


	@Override
	protected int getLayoutId() {
		return R.layout.fragment_passball;
	}

}
