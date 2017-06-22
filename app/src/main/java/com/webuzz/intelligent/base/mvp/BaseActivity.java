package com.webuzz.intelligent.base.mvp;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

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


}
