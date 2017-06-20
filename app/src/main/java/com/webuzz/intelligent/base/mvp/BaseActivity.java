package com.webuzz.intelligent.base.mvp;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.webuzz.intelligent.utils.PermissionManager;

import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * @name ${WeBuzz}
 * @anthor ${WFC}  itjavawfc@163.com
 * @time 2017/6/19 00:43
 * @class describe
 */
public abstract class BaseActivity<T extends BasePresenter> extends SupportActivity implements BaseView {
	private T mPresenter;

	@Override
	@SuppressWarnings("unchecked")
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayoutId());
		ButterKnife.bind(this);
		mPresenter = initPresenter();
		if (mPresenter != null) {
			mPresenter.attachView(this);
		}
		init();
		initView();
		initData();
		initEvent();
	}

	protected void init() {
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (mPresenter != null) {
			mPresenter.detachView();
		}
	}

	protected void initView() {

	}

	protected void initEvent() {

	}

	protected void initData() {

	}

	protected T initPresenter() {
		return null;
	}

	public abstract int getLayoutId();

	protected int getFragmentContentId() {
		return 0;
	}

	public T getPresenter() {
		return mPresenter;
	}

	protected void initToolbar(@NonNull Toolbar toolbar, @Nullable TextView textView, @StringRes int title, @DrawableRes int icon) {
		if (textView != null) {
			textView.setText(title);
		}
		toolbar.setTitle("");
		setSupportActionBar(toolbar);
		toolbar.setNavigationIcon(icon);
	}

	@Override
	public FragmentAnimator onCreateFragmentAnimator() {
		return new DefaultHorizontalAnimator();
	}


	public void requestPermission() {
		String[] permission = needAllowPermission();
		if (PermissionManager.isAllPermissionAllowed(this, permission)) {
			onPermissResult(true);
		} else {
			ActivityCompat.requestPermissions(this, permission, 1000);
		}
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		if (requestCode == 1000) {
			for (int i : grantResults) {
				if (i != PackageManager.PERMISSION_GRANTED) {
					return;
				}
			}
			onPermissResult(true);
		}
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
	}

	public abstract String[] needAllowPermission();

	public abstract void onPermissResult(boolean result);

}
