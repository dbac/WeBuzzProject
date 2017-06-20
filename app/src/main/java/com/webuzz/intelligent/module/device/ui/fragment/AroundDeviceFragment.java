package com.webuzz.intelligent.module.device.ui.fragment;


import com.webuzz.intelligent.R;
import com.webuzz.intelligent.base.mvp.BaseFragment;

public class AroundDeviceFragment extends BaseFragment {


//    public ShootFragment() {
//       return ShootFragment.newInstance();
//     }


	public static AroundDeviceFragment newInstance() {
		AroundDeviceFragment fragment = new AroundDeviceFragment();
		return fragment;
	}


	@Override
	protected int getLayoutId() {
		return R.layout.fragment_arounddevice;
	}

}
