/**
 * @date	2014-10-5
 */
package com.example.myfragment.adapter;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.myfragment.fragment.ExceptionFragment;

/**
 * @author Jxn
 * @date 2014-11-05
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

	ArrayList<Fragment> fragmentList;

	public ViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> list) {
		super(fm);
		fragmentList = list;
	}

	@Override
	public Fragment getItem(int index) {
		if (fragmentList != null) {
			return fragmentList.get(index);
		}
		return new ExceptionFragment();
	}

	@Override
	public int getCount() {
		if (fragmentList != null) {
			return fragmentList.size();
		}
		return 0;
	}

}
