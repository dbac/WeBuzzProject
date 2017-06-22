package com.webuzz.intelligent.base.mvp;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

import com.webuzz.intelligent.utils.PermissionManager;



public abstract class BasePermissActivity<T extends BasePresenter> extends BaseActivity {

	public void requestPermission(String[] permission, int code) {
		if (PermissionManager.isAllPermissionAllowed(this, permission)) {
			onPermissResult(true, code);
		} else {
			ActivityCompat.requestPermissions(this, permission, code);
		}
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		if (requestCode != 10000) {
			for (int i : grantResults) {
				if (i != PackageManager.PERMISSION_GRANTED) {
					onPermissResult(false, requestCode);
					return;
				}
			}
			onPermissResult(true, requestCode);
		} else {
			super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		}
	}

	public abstract void onPermissResult(boolean result, int requestCode);
}
