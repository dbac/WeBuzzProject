package com.webuzz.intelligent.module.sports.ui.fragment;


import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.tencent.bugly.crashreport.CrashReport;
import com.webuzz.intelligent.R;
import com.webuzz.intelligent.base.WebuzzApp;
import com.webuzz.intelligent.base.mvp.BaseFragment;
import com.webuzz.intelligent.utils.IntentUtils;
import com.webuzz.intelligent.view.ArcProgress;
import com.webuzz.intelligent.view.TextCircleView;

import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;

public class ShootFragment extends BaseFragment {
    private static final String TAG = "ShootFragment";


    @BindView(R.id.arc_progress)
    ArcProgress mArcProgress;
    @BindView(R.id.falan_progress)
    ArcProgress mFalanProgress;
    @BindView(R.id.zhongtou_progress)
    ArcProgress mZhongtouProgress;
    @BindView(R.id.yuantou_progress)
    ArcProgress mYuantouProgress;

    int minArc, minFalan, minZhongtou, minYuantou;
    int maxArc, maxFalan, maxZhongtou, maxYuantou;



    private Handler handler = new Handler();
    private Runnable runnable;

    public static ShootFragment newInstance() {
        ShootFragment fragment = new ShootFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        Log.w(TAG, "getLayoutId: " + R.layout.fragment_shoot);
        return R.layout.fragment_shoot;
    }

    @Override
    protected void initData() {
        Random random = new Random();
        maxArc = random.nextInt(500) + 1;
        minArc = random.nextInt(maxArc) + 1;
        mArcProgress.setMax(100);

        maxFalan = random.nextInt(100) + 1;
        minFalan = random.nextInt(maxFalan) + 1;
        mFalanProgress.setMax(100);

        maxZhongtou = random.nextInt(500) + 1;
        minZhongtou = random.nextInt(maxZhongtou) + 1;
        mZhongtouProgress.setMax(100);

        maxYuantou = random.nextInt(100) + 1;
        minYuantou = random.nextInt(maxYuantou) + 1;
        mYuantouProgress.setMax(100);

        mArcProgress.setBottomText(minArc + " / " + maxArc);
        mFalanProgress.setBottomText(minFalan + " / " + maxFalan);
        mZhongtouProgress.setBottomText(minZhongtou + " / " + maxZhongtou);
        mYuantouProgress.setBottomText(minYuantou + " / " + maxYuantou);

        mArcProgress.setProgress(minArc * 100 / maxArc);
        mFalanProgress.setProgress(minFalan * 100 / maxFalan);
        mZhongtouProgress.setProgress(minZhongtou * 100 / maxZhongtou);
        mYuantouProgress.setProgress(minYuantou * 100 / maxYuantou);


        runnable = new Runnable() {
            public void run() {
                dataChenged();
                handler.postDelayed(this, 3000);
            }
        };
        handler.postDelayed(runnable, 1000);
    }


    private void dataChenged() {
        isSetDefault();
        minArc = minArc + 1;
        minFalan = minFalan + 1;
        minZhongtou = minZhongtou + 1;
        minYuantou = minYuantou + 1;

        mArcProgress.setBottomText(minArc + " / " + maxArc);
        mFalanProgress.setBottomText(minFalan + " / " + maxFalan);
        mZhongtouProgress.setBottomText(minZhongtou + " / " + maxZhongtou);
        mYuantouProgress.setBottomText(minYuantou + " / " + maxYuantou);

        mArcProgress.setProgress(minArc * 100 / maxArc);
        mFalanProgress.setProgress(minFalan * 100 / maxFalan);
        mZhongtouProgress.setProgress(minZhongtou * 100 / maxZhongtou);
        mYuantouProgress.setProgress(minYuantou * 100 / maxYuantou);
    }

    private void isSetDefault() {
        if (minArc >= maxArc)
            minArc = 0;
        if (minFalan >= maxFalan)
            minFalan = 0;

        if (minZhongtou >= maxZhongtou)
            minZhongtou = 0;
        if (minYuantou >= maxYuantou)
            minYuantou = 0;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacks(runnable);
    }

    @OnClick({R.id.start})
    void butterknifeOnClick(View view) {
        switch (view.getId()) {
            case R.id.start:
                //IntentUtils.startActivity(WebuzzApp.getContext(),);
                break;
            default:
                break;
        }
    }



}
