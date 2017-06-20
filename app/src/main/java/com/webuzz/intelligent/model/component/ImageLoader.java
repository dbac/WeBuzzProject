package com.webuzz.intelligent.model.component;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;


public class ImageLoader {

	private ImageLoader() {
	}

	public static ImageLoader getInstance() {
		return Singleton.LOADER;
	}

	public void displayImage(Context context, String url, ImageView view) {
		Glide.with(context).
				load(url).
				crossFade().
				into(view);
	}

	public void displayImage(Context context, int url, ImageView view) {
		Glide.with(context).
				load(url).
				crossFade(1000).
				into(view);
	}

	public void displayImage(Fragment fragment, String url, ImageView view) {
		if (!fragment.isDetached()) {
			Glide.with(fragment).
					load(url).
					crossFade().
					into(view);
		}
	}

  /*  public void displayImage(Activity activity, String url, ImageView view) {
        if (!activity.isDestroyed()) {
            Glide.with(activity).
                    load(url).
                    crossFade().
                    into(view);
        }
    }*/

	public void displayCircleImage(Fragment fragment, String url, ImageView view) {
		if (!fragment.isDetached()) {
			Glide.with(fragment).
					load(url).
					crossFade().
					bitmapTransform(new CropCircleTransformation(Glide.get(fragment.getActivity()).getBitmapPool())).
					into(view);
		}
	}

   /* public void displayCircleImage(Activity activity, String url, ImageView view) {
        if (!activity.isDestroyed()) {
            Glide.with(activity)
                    .load(url)
                    .crossFade()
                    .placeholder(R.drawable.mine_head)
                    .error(R.drawable.mine_head)
                    .bitmapTransform(new CropCircleTransformation(Glide.get(activity).getBitmapPool()))
                    .into(view);
        }
    }*/


  /*  public void displayCircleImage(Context context, String url, ImageView view) {
        Glide.with(context).
                load(url).
                crossFade()
                .placeholder(R.drawable.mine_head)
                .error(R.drawable.mine_head).
                bitmapTransform(new CropCircleTransformation(Glide.get(context).getBitmapPool())).
                into(view);
    }*/

	public void displayImageGray(Context context, String url, ImageView view) {
		Glide.with(context).
				load(url).
				crossFade().
				bitmapTransform(new GrayscaleTransformation(context)).
				into(view);
	}

	private static class Singleton {
		private static final ImageLoader LOADER = new ImageLoader();
	}

}
