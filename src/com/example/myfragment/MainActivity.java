package com.example.myfragment;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.example.myfragment.adapter.ViewPagerAdapter;
import com.example.myfragment.fragment.AssortmentPageFragment;
import com.example.myfragment.fragment.HomeFragments;
import com.example.myfragment.fragment.MinePageFragment;
import com.example.myfragment.fragment.ShopCarPageFragment;
import com.example.myfragment.fragment.StrollPageFragment;

/**
 * 首页面导航
 * 
 * @author 高勇
 * @date 2014-11-5
 */
public class MainActivity extends ActionBarActivity {
	private ViewPager viewPage;
	private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();;
	private ViewPagerAdapter adapter;
	private RadioGroup tabGroup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initList();
		initRes();
		initListener();
	}

	private void initList() {
		fragmentList.add(new HomeFragments());
		fragmentList.add(new AssortmentPageFragment());
		fragmentList.add(new StrollPageFragment());
		fragmentList.add(new ShopCarPageFragment());
		fragmentList.add(new MinePageFragment());
	}

	private void initRes() {
		tabGroup = (RadioGroup) findViewById(R.id.rg_tab);
		viewPage = (ViewPager) findViewById(R.id.home_viewpager);
		Log.e("test", viewPage + "");
		adapter = new ViewPagerAdapter(this.getSupportFragmentManager(),
				fragmentList);
		viewPage.setOffscreenPageLimit(1);
		viewPage.setAdapter(adapter);
		viewPage.setCurrentItem(0);
		((RadioButton) tabGroup.getChildAt(0)).setChecked(true);

	}

	private void initListener() {
		viewPage.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				RadioButton rb = (RadioButton) tabGroup.getChildAt(arg0);
				rb.setChecked(true);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
		tabGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				int selectPosition = 0;
				switch (checkedId) {
				case R.id.rb_home:
					selectPosition = 0;
					break;
				case R.id.rb_assort:
					selectPosition = 1;
					break;
				case R.id.rb_stroll:
					selectPosition = 2;
					break;
				case R.id.rb_shopcar:
					selectPosition = 3;
					break;
				case R.id.rb_mine:
					selectPosition = 4;
					break;
				default:
					break;
				}
				viewPage.setCurrentItem(selectPosition);

			}
		});
	}
}
