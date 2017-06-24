package com.webuzz.intelligent.module.mine.ui.fragment;


import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.blankj.utilcode.utils.ToastUtils;
import com.bumptech.glide.Glide;
import com.miguelbcr.ui.rx_paparazzo2.RxPaparazzo;
import com.webuzz.intelligent.R;
import com.webuzz.intelligent.base.WebuzzApp;
import com.webuzz.intelligent.base.mvp.BaseItemFragment;
import com.webuzz.intelligent.module.mine.adapter.MineFragmentAdapter;
import com.webuzz.intelligent.module.mine.bean.ScoreCategory;
import com.webuzz.intelligent.module.mine.mvp.contract.MineFragmentContract;
import com.webuzz.intelligent.module.mine.mvp.presenter.MineFragmentPresenterImpl;
import com.webuzz.intelligent.view.CircleImageView;
import com.yalantis.ucrop.UCrop;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class MineFragment extends BaseItemFragment<MineFragmentPresenterImpl> implements MineFragmentContract.View {

	private static final String ARG_PARAM1 = "param1";
	private static final String ARG_PARAM2 = "param2";

	@BindView(R.id.scorecategory)
	RecyclerView scoreCategoryView;
	@BindView(R.id.rlminehistory)
	RelativeLayout rlminehistory;
	@BindView(R.id.rlsetting)
	RelativeLayout rlsetting;

	@BindView(R.id.userlogo)
	CircleImageView userlogo;




	@BindView(R.id.rlabout)
	RelativeLayout rlabout;

	MineFragmentAdapter mAdapter;

	@BindView(R.id.toolbar)
	Toolbar toolbar;


	private String mParam1;
	private String mParam2;


	public MineFragment() {
	}

	public static MineFragment newInstance() {
		MineFragment fragment = new MineFragment();
		return fragment;
	}

	@Override
	protected void init() {
		mAdapter = new MineFragmentAdapter();
	}

	@Override
	protected void initView(View view) {
		initRecyclerView();
		initToolBar();
	}

	@Override
	protected MineFragmentPresenterImpl initPresenter() {
		return new MineFragmentPresenterImpl();
	}

	@Override
	protected void initData() {
		getPresenter().loadData();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			mParam1 = getArguments().getString(ARG_PARAM1);
			mParam2 = getArguments().getString(ARG_PARAM2);
		}
	}


	private void initRecyclerView() {
		scoreCategoryView.setLayoutManager(new GridLayoutManager(WebuzzApp.getContext(), 4));
		scoreCategoryView.setItemAnimator(new DefaultItemAnimator());
		scoreCategoryView.setAdapter(mAdapter);
	}

	@Override
	protected int getLayoutId() {
		return R.layout.fragment_mine;
	}


	@Override
	public void showRecyclerView(List<ScoreCategory> smartReminds) {
		mAdapter.setData(smartReminds);
		mAdapter.notifyDataSetChanged();
	}

	@Override
	public void showProgressView() {

	}

	@Override
	public void showEmptyView() {

	}

	@Override
	public void showErrorView() {

	}

	private void initToolBar() {
		toolbar.setTitle(getString(R.string.mine));
		((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

	}

	@OnClick({R.id.rlminehistory, R.id.rlsetting, R.id.rlabout,R.id.userlogo})
	void butterknifeOnClick(View view) {
		switch (view.getId()) {
			case R.id.rlminehistory:
				Toasty.normal(WebuzzApp.getContext(), "历史记录！", 0).show();
				break;
			case R.id.rlsetting:
				Toasty.normal(WebuzzApp.getContext(), "设置！", 0).show();
				break;
			case R.id.rlabout:
				Toasty.normal(WebuzzApp.getContext(), "关于！", 0).show();
				break;
				case R.id.userlogo:
					//changeUserPic();
				break;
		}
	}

	private void changeUserPic() {

		UCrop.Options options = new UCrop.Options();
		int color = ContextCompat.getColor(WebuzzApp.getContext(), R.color.color_primary);
		options.setToolbarColor(color);
		options.setStatusBarColor(ContextCompat.getColor(WebuzzApp.getContext(), R.color.color_primary_dark));
		options.setActiveWidgetColor(color);

		final Context context =getActivity();
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle("Tips:")
				.setMessage("如何获取图片？")
				.setPositiveButton(getString(R.string.user_gallery), (DialogInterface dialog, int which) -> {
					dialog.dismiss();

					RxPaparazzo.single(this)
							.usingGallery()
							.subscribeOn(Schedulers.io())
							.observeOn(AndroidSchedulers.mainThread())
							.subscribe(response -> {
								// See response.resultCode() doc
								if (response.resultCode() != RESULT_OK) {
									//response.targetUI().showUserCanceled();
									//response.targetUI().showProgressView();

									//String filePath = response.data();
									//response.data().getFile();

									Glide.with(WebuzzApp.getContext()).load(response.data().getFile()).into(userlogo);
									//TApplication.getSpUtils().putString(Constant.STRING_USER, filePath);//保存图片路径

									return;
								}

								//response.targetUI().loadImage(response.data());
							});



				});
				/*.setNeutralButton(getString(R.string.cancel), (dialog, which) -> dialog.dismiss())
				.setNegativeButton(getString(R.string.user_carema), (dialog, which) -> {
					dialog.dismiss();
					RxPaparazzo.takeImage(UserFragment.this)
							.crop(options)
							.usingCamera()
							.subscribeOn(Schedulers.io())
							.observeOn(AndroidSchedulers.mainThread())
							.subscribe(response -> {
								if (response.resultCode() == Activity.RESULT_OK) {
									String filePath = response.data();
									Glide.with(this).load(filePath).into(iv_appbar);
									App.getSpUtils().putString(Constants.STRING_USER, filePath);//保存图片路径
								} else if (response.resultCode() == Activity.RESULT_CANCELED) {
									ToastUtils.showShortToast(getString(R.string.user_carema_cancel));
								} else {
									ToastUtils.showShortToast(getString(R.string.error_unknown));
								}
							});
				});*/
		AlertDialog dialog = builder.create();
		dialog.show();

		dialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(ContextCompat.getColor(context, R.color.color_primary));
		dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(ContextCompat.getColor(context, R.color.color_primary));
		//dialog.getButton(DialogInterface.BUTTON_NEUTRAL).setTextColor(ContextCompat.getColor(context, R.color.color_secondary_text));



	}
}