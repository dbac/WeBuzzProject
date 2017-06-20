package com.webuzz.intelligent.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kosasih on 10/23/2015.
 */
public class PermissionManager {
	public static List<String> getAllPermission(Context context) {
		try {
			PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_PERMISSIONS);
			List<String> ret = new ArrayList<String>();
			for (String permisson : packageInfo.requestedPermissions) {
				if (
						!permisson.equals("android.permission.CAMERA") &&
								!permisson.equals("android.permission.READ_PHONE_STATE") &&
								!permisson.equals("android.permission.RECORD_AUDIO")
						) {
					ret.add(permisson);
				}
			}
			return ret;
		} catch (PackageManager.NameNotFoundException e) {
			return null;
		}
	}

	public static boolean isAllPermissionAllowed(Context conttext, List<String> requestedPermissions) {
		if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.M) {
			return true;
		} else {
			for (String permission : requestedPermissions) {
				if (!isAllowPermission(conttext, permission)) {
					return false;
				}
			}
		}
		return true;
	}


	public static boolean isAllPermissionAllowed(Context conttext, String[] requestedPermissions) {
		if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.M) {
			return true;
		} else {
			if (requestedPermissions != null) {
				for (String permission : requestedPermissions) {
					if (!isAllowPermission(conttext, permission)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static List<String> getNotAllowedPermissions(Context conttext, List<String> requestedPermissions) {
		if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.M) {
			return null;
		} else {
			List<String> noAllowListString = new ArrayList<>();
			for (String permission : requestedPermissions) {
				if (!isAllowPermission(conttext, permission)) {
					Log.e("meifei", "now allowed permission " + permission);

					noAllowListString.add(permission);
				}
			}
			return noAllowListString;
		}
	}

	public static boolean isAllowPermission(Context context, String permisss) {
		if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.M) {
			return true;
		} else {
			int result = ContextCompat.checkSelfPermission(context, permisss);
			if (result != PackageManager.PERMISSION_GRANTED) {
				return false;
			}
		}
		return true;
	}
}
