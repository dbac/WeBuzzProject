package com.webuzz.intelligent.module.sports.listener;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.RadioGroup;

import com.webuzz.intelligent.R;

public class RadioCheckChangeListener implements RadioGroup.OnCheckedChangeListener {

	ViewPager mPager;


	private RadioCheckChangeListener() {
	}

	public static RadioCheckChangeListener getInstance() {
		return RadioCheckChangeListenerHolder.instance;
	}

	public ViewPager getmPager() {
		return mPager;
	}

	public void setmPager(ViewPager mPager) {
		this.mPager = mPager;
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		Log.e("wfc", "onCheckedChanged: " + checkedId + "   ");
		switch (checkedId) {
			case R.id.shoot:
				//mPager.setCurrentItem(0, false);
				mPager.setCurrentItem(0);
				break;
			case R.id.dribble:
				//  mPager.setCurrentItem(1, false);
				mPager.setCurrentItem(1);
				break;
			case R.id.passball:
				//mPager.setCurrentItem(2, false);
				mPager.setCurrentItem(2);
				break;
			case R.id.classroom:
				//mPager.setCurrentItem(3, false);
				mPager.setCurrentItem(3);
				break;
			default:
				break;
		}
	}

	private static class RadioCheckChangeListenerHolder {
		private static RadioCheckChangeListener instance = new RadioCheckChangeListener();
	}
}
