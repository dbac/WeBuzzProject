package com.webuzz.intelligent.module.device.ui.fragment;


import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.sevenheaven.segmentcontrol.SegmentControl;
import com.webuzz.intelligent.R;
import com.webuzz.intelligent.base.mvp.BaseFragment;
import com.webuzz.intelligent.module.mine.adapter.MediaFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnPageChange;


public class DeviceFragment extends BaseFragment implements SegmentControl.OnSegmentControlClickListener {

    @BindView(R.id.viewPager)
    ViewPager mPager;

    @BindView(R.id.segment_control)
    SegmentControl segmentControl;

    List<Fragment> fragmentList = new ArrayList<>();

    Fragment mineDeviceFragment = MineDeviceFragment.newInstance();
    Fragment aroundDeviceFragment = AroundDeviceFragment.newInstance();


    public DeviceFragment() {
        fragmentList.add(mineDeviceFragment);
        fragmentList.add(aroundDeviceFragment);
    }


    public static DeviceFragment newInstance() {
        DeviceFragment fragment = new DeviceFragment();
        return fragment;
    }


    @Override
    protected void initData() {
        super.initData();
        mPager.setAdapter(new MediaFragmentPagerAdapter(getActivity().getSupportFragmentManager(), fragmentList));

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_device;
    }


    @OnPageChange(R.id.viewPager)
    void onPageSelected(int position) {
        segmentControl.setSelectedIndex(position);

    }


    @Override
    public void onSegmentControlClick(int index) {
        mPager.setCurrentItem(index);

    }
}
