package com.webuzz.intelligent.module.mine.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @name WeBuzz
 * @class name：com.webuzz.intelligent.module.mine.adapter
 * @class describe
 * @anthor wfc QQ:335441537
 * @time 2017/6/19 23:10
 * @change
 * @chang time
 * @class describe
 */
public class MediaFragmentPagerAdapter extends FragmentPagerAdapter {
	List<Fragment> list;

	public MediaFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
		super(fm);
		this.list = list;
	}

	@Override
	public Fragment getItem(int position) {
		return list.get(position);
	}

	@Override
	public int getCount() {
		return list.size();
	}
}
