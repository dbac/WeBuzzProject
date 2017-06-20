package com.webuzz.intelligent.module.sports.listener;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.RadioGroup;

import com.webuzz.intelligent.R;

/**
 * Created by lilin on 2017/6/19.
 */

public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

	RadioGroup mGroup;


	private MyOnPageChangeListener() {
	}

	public static MyOnPageChangeListener getInstance() {
		return MyOnPageChangeListener.MyOnPageChangeListenerHolder.instance;
	}

	public RadioGroup getmGroup() {
		return mGroup;
	}

	public void setmGroup(RadioGroup mGroup) {
		this.mGroup = mGroup;
	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
	}

	@Override
	public void onPageSelected(int position) {
		Log.e("wfc", "onPageSelected: " + position);

		switch (position) {
			case 0:
				mGroup.check(R.id.shoot);
				break;
			case 1:
				mGroup.check(R.id.dribble);
				break;
			case 2:
				mGroup.check(R.id.passball);
				break;
			case 3:
				mGroup.check(R.id.classroom);
				break;
		}
	}

	@Override
	public void onPageScrollStateChanged(int state) {

	}

	private static class MyOnPageChangeListenerHolder {
		private static MyOnPageChangeListener instance = new MyOnPageChangeListener();
	}
}
