package com.webuzz.intelligent.module.sports.ui.fragment;


import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.sevenheaven.segmentcontrol.SegmentControl;
import com.webuzz.intelligent.R;
import com.webuzz.intelligent.base.mvp.BaseFragment;
import com.webuzz.intelligent.module.mine.adapter.MediaFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class SportsFragment extends BaseFragment implements ViewPager.OnPageChangeListener,SegmentControl.OnSegmentControlClickListener{  //, RadioGroup.OnCheckedChangeListener
	private static final String TAG = "SportsFragment";

	@BindView(R.id.viewPager)
	ViewPager mPager;

//	@BindView(R.id.radiogroup)
//	RadioGroup mGroup;

	@BindView(R.id.rg_item)
	RadioGroup mItemGroup;

//	@BindView(R.id.shoot)
//	RadioButton shoot;
//	@BindView(R.id.dribble)
//	RadioButton dribble;
//	@BindView(R.id.passball)
//	RadioButton passball;
//	@BindView(R.id.classroom)
//	RadioButton classroom;

	@BindView(R.id.segment_control)
	SegmentControl segmentControl;

	List<Fragment> fragmentList = new ArrayList<>();

	Fragment sportsFragment = ShootFragment.newInstance();
	Fragment dribbleFragment = DribbleFragment.newInstance();
	Fragment passBallFragment = PassBallFragment.newInstance();
	Fragment classRoomFragment = ClassRoomFragment.newInstance();

	public SportsFragment() {
		fragmentList.add(sportsFragment);
		fragmentList.add(dribbleFragment);
		fragmentList.add(passBallFragment);
		fragmentList.add(classRoomFragment);
	}


	public static SportsFragment newInstance() {
		SportsFragment fragment = new SportsFragment();
		return fragment;
	}

	@Override
	protected void initEvent() {
		//mGroup.setOnCheckedChangeListener(this);
		mPager.addOnPageChangeListener(this);
		segmentControl.setOnSegmentControlClickListener(this);
	}


	@Override
	protected void initData() {
		mPager.setAdapter(new MediaFragmentPagerAdapter(getChildFragmentManager(), fragmentList));
		mItemGroup.check(R.id.rb_item1);
		mPager.setCurrentItem(0);
	}


	@Override
	protected int getLayoutId() {
		return R.layout.fragment_sports;
	}



	@Override
	public void onSegmentControlClick(int index) {
		mPager.setCurrentItem(index);
	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
		Log.d(TAG, "onPageScrolled() called with: position = [" + position + "], positionOffset = [" + positionOffset + "], positionOffsetPixels = [" + positionOffsetPixels + "]");
	}

	@Override
	public void onPageSelected(int position) {
		segmentControl.setSelectedIndex(position);
		switch (position) {
			case 0:
			//	mGroup.check(R.id.shoot);
			 	mItemGroup.check(R.id.rb_item1);
				break;
			case 1:
			//	mGroup.check(R.id.dribble);
			 	mItemGroup.check(R.id.rb_item2);
				break;
			case 2:
			//	mGroup.check(R.id.passball);
			 	mItemGroup.check(R.id.rb_item3);
				break;
			case 3:
			//	mGroup.check(R.id.classroom);
			 	mItemGroup.check(R.id.rb_item4);
				break;
		}
	}

	@Override
	public void onPageScrollStateChanged(int state) {

	}

	/*@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
			case R.id.shoot:
				mPager.setCurrentItem(0);
				mItemGroup.check(R.id.rb_item1);
				break;
			case R.id.dribble:
				mPager.setCurrentItem(1);
				mItemGroup.check(R.id.rb_item2);
				break;
			case R.id.passball:
				mPager.setCurrentItem(2);
				mItemGroup.check(R.id.rb_item3);
				break;
			case R.id.classroom:
				mPager.setCurrentItem(3);
				mItemGroup.check(R.id.rb_item4);
				break;
			default:
				break;
		}
	}*/


}
