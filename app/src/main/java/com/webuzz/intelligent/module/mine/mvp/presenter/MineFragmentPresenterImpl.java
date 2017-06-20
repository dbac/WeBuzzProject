package com.webuzz.intelligent.module.mine.mvp.presenter;


import com.webuzz.intelligent.base.mvp.RxPresenter;
import com.webuzz.intelligent.module.mine.bean.ScoreCategory;
import com.webuzz.intelligent.module.mine.mvp.contract.MineFragmentContract;
import com.webuzz.intelligent.module.mine.mvp.model.MineFragmentModelImpl;

import java.util.ArrayList;
import java.util.List;

public class MineFragmentPresenterImpl extends RxPresenter<MineFragmentContract.View, MineFragmentContract.Model> implements
		MineFragmentContract.Presenter<MineFragmentContract.View> {

	public MineFragmentPresenterImpl() {
		mModel = new MineFragmentModelImpl();
	}

	@Override
	public void loadData() {

		List<ScoreCategory> scoreCategories = new ArrayList<>();

		scoreCategories.add(new ScoreCategory("运球", "433"));
		scoreCategories.add(new ScoreCategory("传球", "85"));
		scoreCategories.add(new ScoreCategory("投篮", "287"));
		scoreCategories.add(new ScoreCategory("进球", "176"));

		scoreCategories.add(new ScoreCategory("健走(km)", "0.0"));
		scoreCategories.add(new ScoreCategory("慢跑(km)", "0.0"));
		scoreCategories.add(new ScoreCategory("散步", "0.0"));
		scoreCategories.add(new ScoreCategory("跳绳", "0"));

		scoreCategories.add(new ScoreCategory("向上垫球", "0"));
		scoreCategories.add(new ScoreCategory("对墙垫球", "0"));
		scoreCategories.add(new ScoreCategory("向上托球", "0"));
		scoreCategories.add(new ScoreCategory("对墙托球", "0"));

		mView.showRecyclerView(scoreCategories);

	}


	@Override
	public void detachView() {
		super.detachView();
	}
}