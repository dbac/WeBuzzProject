package com.webuzz.intelligent.module.sports.ui.fragment;


import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import com.sevenheaven.segmentcontrol.SegmentControl;
import com.webuzz.intelligent.R;
import com.webuzz.intelligent.base.mvp.BaseFragment;
import com.webuzz.intelligent.module.mine.adapter.MediaFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnPageChange;


public class SportsFragment extends BaseFragment implements SegmentControl.OnSegmentControlClickListener {

    @BindView(R.id.viewPager)
    ViewPager mPager;

    @BindView(R.id.rg_item)
    RadioGroup mItemGroup;

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


    @OnPageChange(R.id.viewPager)
    void onPageSelected(int position) {
        segmentControl.setSelectedIndex(position);
        switch (position) {
            case 0:
                mItemGroup.check(R.id.rb_item1);
                break;
            case 1:
                mItemGroup.check(R.id.rb_item2);
                break;
            case 2:
                mItemGroup.check(R.id.rb_item3);
                break;
            case 3:
                mItemGroup.check(R.id.rb_item4);
                break;
        }
    }


}
