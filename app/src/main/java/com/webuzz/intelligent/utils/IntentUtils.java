package com.webuzz.intelligent.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


public class IntentUtils {

    public static <T extends Activity> Intent getIntent(Context context, Class<T> clazz) {
        return new Intent(context, clazz);
    }

    public static <T extends Activity> void startActivity(Context context, Class<T> clazz) {
        context.startActivity(getIntent(context, clazz));
    }

    public static <T extends Activity> void startActivityData(Context context, Class<T> clazz, String key, Bundle bundle) {
        Intent intent = getIntent(context, clazz);
        intent.putExtra(key, bundle);
        context.startActivity(intent);
    }

    public static <T extends Activity> boolean isActivityRegistered(Context context, Class<T> clazz) {
        Intent intent = getIntent(context, clazz);
        return !(context.getPackageManager().resolveActivity(intent, 0) == null ||
                intent.resolveActivity(context.getPackageManager()) == null ||
                context.getPackageManager().queryIntentActivities(intent, 0).size() == 0);
    }


    public static <T extends Activity> void skipOtherActivity(Activity context, Class<T> classname, String key, String type) {
        Intent intent = new Intent();
        intent.putExtra(key, type);
        intent.setClass(context, classname);
        context.startActivityForResult(intent, 0);
    }


}
