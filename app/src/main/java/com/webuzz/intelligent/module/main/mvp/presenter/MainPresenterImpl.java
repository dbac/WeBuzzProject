package com.webuzz.intelligent.module.main.mvp.presenter;

import android.content.Context;
import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.webuzz.intelligent.R;
import com.webuzz.intelligent.base.WebuzzApp;
import com.webuzz.intelligent.base.mvp.RxPresenter;
import com.webuzz.intelligent.module.main.mvp.contract.MainContract;
import com.webuzz.intelligent.module.main.mvp.model.MainModelImpl;


public class MainPresenterImpl extends RxPresenter<MainContract.View, MainModelImpl> implements MainContract.Presenter<MainContract.View> {


	public MainPresenterImpl() {
		mModel = new MainModelImpl();

	}


	@Override
	public void login(Context context) {

	}

	@Override
	public void setCustomViewData(TabLayout mTabLayout) {
		View viewdevice = LayoutInflater.from(WebuzzApp.getContext()).inflate(R.layout.layout_tab, mTabLayout, false);
		((ImageView) viewdevice.findViewById(R.id.icon)).setImageResource(R.drawable.tab_select_device);
		((TextView) viewdevice.findViewById(Resources.getSystem().getIdentifier("text1", "id", "android"))).setTextColor(
				ContextCompat.getColorStateList(WebuzzApp.getContext(), R.color.main_tab_text_color)
		);
		mTabLayout.getTabAt(0).setCustomView(viewdevice);


		View viewsport = LayoutInflater.from(WebuzzApp.getContext()).inflate(R.layout.layout_tab, mTabLayout, false);
		((ImageView) viewsport.findViewById(R.id.icon)).setImageResource(R.drawable.tab_select_sports);
		((TextView) viewsport.findViewById(Resources.getSystem().getIdentifier("text1", "id", "android"))).setTextColor(
				ContextCompat.getColorStateList(WebuzzApp.getContext(), R.color.main_tab_text_color)
		);
		mTabLayout.getTabAt(1).setCustomView(viewsport);

		View viewmine = LayoutInflater.from(WebuzzApp.getContext()).inflate(R.layout.layout_tab, mTabLayout, false);
		((ImageView) viewmine.findViewById(R.id.icon)).setImageResource(R.drawable.tab_select_mine);
		((TextView) viewmine.findViewById(Resources.getSystem().getIdentifier("text1", "id", "android"))).setTextColor(
				ContextCompat.getColorStateList(WebuzzApp.getContext(), R.color.main_tab_text_color)
		);
		mTabLayout.getTabAt(2).setCustomView(viewmine);
	}


}