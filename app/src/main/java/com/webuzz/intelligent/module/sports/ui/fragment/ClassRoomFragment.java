package com.webuzz.intelligent.module.sports.ui.fragment;


import com.webuzz.intelligent.R;
import com.webuzz.intelligent.base.mvp.BaseFragment;

public class ClassRoomFragment extends BaseFragment {


	public static ClassRoomFragment newInstance() {
		ClassRoomFragment fragment = new ClassRoomFragment();
		return fragment;
	}


	@Override
	protected int getLayoutId() {
		return R.layout.fragment_classroom;
	}

}
