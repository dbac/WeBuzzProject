package com.webuzz.intelligent.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;


public class FragmentManager {

	public static <T extends Fragment> T getFragment(FragmentActivity activity, Class<T> t, String tag) {
		return (T) activity.getSupportFragmentManager().
				findFragmentByTag((tag == null ? "" : tag));
	}

	public static <T extends Fragment> T getFragment(FragmentActivity activity, Class<T> t) {
		return (T) activity.getSupportFragmentManager().findFragmentByTag(t.getName());
	}

	public static <T extends Fragment> T createFragment(Class<T> t) {
		try {
			return t.newInstance();
		} catch (Exception e) {
		}
		return null;
	}

//    public static <T> T replaceFragment(FragmentActivity activity, Class<T> t){
//        return replaceFragment(activity,t,null);
//    }
//
//    public static <T> T replaceFragment(FragmentActivity activity, Class<T> t, Bundle bundle){
//        Fragment fragment= (Fragment) getFragment(activity,t);
//        if(fragment != null){
//            return (T)fragment;
//        }else{
//            try {
//                Fragment tObj = (Fragment) t.newInstance();
//                tObj.setArguments(bundle);
//                activity.getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.fragment_container,tObj,t.getName())
//                        .commitAllowingStateLoss();
//                return (T)tObj;
//            }catch(Exception e){
//                return null;
//            }
//        }
//    }
//    public static void popbackFragment(FragmentActivity activity){
//        activity.getSupportFragmentManager().popBackStack();
//    }
//
//    public static <T> T addFragment(FragmentActivity activity, Class<T> t, Fragment currentFragment){
//        return addFragment(activity,t,currentFragment,null);
//    }
//
//    public static <T> T addFragment(FragmentActivity activity, Class<T> t, Fragment currentFragment , Bundle bundle){
//        List<Fragment> fragments = activity.getSupportFragmentManager().getFragments();
//        if(fragments == null || fragments.size() <= 0){
//            return replaceFragment(activity,t,bundle);
//        }else{
//            Fragment fragment= (Fragment) getFragment(activity,t);
//            if(fragment != null){
//                return (T)fragment;
//            }else{
//                try{
//                    Fragment tObj = (Fragment) t.newInstance();
//                    tObj.setArguments(bundle);
//                    if(currentFragment != null) {
//                        activity.getSupportFragmentManager().beginTransaction()
//                                .hide(currentFragment)
//                                .add(R.id.fragment_container,tObj,t.getName())
//                                .addToBackStack(null)
//                                .commitAllowingStateLoss();
//                        return (T)tObj;
//                    }else {
//                        activity.getSupportFragmentManager().beginTransaction()
//                                .add(R.id.fragment_container,tObj,t.getName())
//                                .addToBackStack(null)
//                                .commitAllowingStateLoss();
//                        return (T)tObj;
//                    }
//                }catch (Exception e){
//                    return null;
//                }
//
//            }
//        }
//    }
}
