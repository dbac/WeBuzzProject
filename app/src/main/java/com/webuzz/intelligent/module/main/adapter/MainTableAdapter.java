package com.webuzz.intelligent.module.main.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.webuzz.intelligent.R;
import com.webuzz.intelligent.base.WebuzzApp;
import com.webuzz.intelligent.module.device.ui.fragment.DeviceFragment;
import com.webuzz.intelligent.module.mine.ui.fragment.MineFragment;
import com.webuzz.intelligent.module.sports.ui.fragment.SportsFragment;

/**
 * @name WeBuzz
 * @class name：com.webuzz.intelligent.module.main.adapter
 * @class describe
 * @anthor wfc QQ:335441537
 * @time 2017/6/19 02:54
 * @change
 * @chang time
 * @class describe
 */
public class MainTableAdapter extends FragmentStatePagerAdapter {
	private Fragment deviceFragment, sportsFragment, mineFragment;

	public MainTableAdapter(android.support.v4.app.FragmentManager fm) {
		super(fm);
	}


	@Override
	public Fragment getItem(int position) {

		switch (position) {
			case 0:
				if (deviceFragment == null) {
					//deviceFragment = FragmentManager.createFragment(DeviceFragment.class);
					deviceFragment = DeviceFragment.newInstance();
				}

				return deviceFragment;
			case 1:
				if (sportsFragment == null) {
					// sportsFragment = FragmentManager.createFragment(SportsFragment.class);
					sportsFragment = SportsFragment.newInstance();
				}
				return sportsFragment;
			case 2:
				if (mineFragment == null) {
					//mineFragment = FragmentManager.createFragment(MineFragment.class);
					mineFragment = MineFragment.newInstance();
				}
				return mineFragment;
			default:
				return null;
		}


	}

	@Override
	public int getCount() {
		return 3;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		switch (position) {
			case 0:
				return WebuzzApp.getContext().getString(R.string.tab_device);
			case 1:
				return WebuzzApp.getContext().getString(R.string.tab_sport);
			case 2:
				return WebuzzApp.getContext().getString(R.string.tab_mine);

			default:
				return null;
		}
	}

}
