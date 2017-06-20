package com.webuzz.intelligent.module.sports.ui.fragment;


import com.webuzz.intelligent.R;
import com.webuzz.intelligent.base.mvp.BaseFragment;

public class DribbleFragment extends BaseFragment {


//    public ShootFragment() {
//       return ShootFragment.newInstance();
//     }


	public static DribbleFragment newInstance() {
		DribbleFragment fragment = new DribbleFragment();
		return fragment;
	}


	@Override
	protected int getLayoutId() {
		return R.layout.fragment_dribble;
	}

}
