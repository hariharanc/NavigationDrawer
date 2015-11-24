package com.example.navigationdrawer;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

/**
 * The main purpose of this class to display the list of item in drawer then
 * press the drawer item to replace the fragment based on the user list
 * selection
 */

public class MainActivity extends AppCompatActivity implements
		OnItemClickListener, OnClickListener {
	public static final String[] data = { "One", "Two", "Three" };
	public static final Integer[] images = { R.drawable.home_img,
			R.drawable.home_img, R.drawable.home_img };
	public static final String[] fragments = {
			"com.example.navigationdrawer.FragmentOne",
			"com.example.navigationdrawer.FragmentTwo",
			"com.example.navigationdrawer.FragmentThree" };;
	private DrawerLayout mDrawer;
	private RelativeLayout mLlleftDrawer;
	private LinearLayout mLlMenuDrawer;
	private ListView mListDrawer;
	private DrawerListViewAdapter mDrawerListViewAdapter;
	private List<DrawerItem> mliDrawerItems;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// create the array list object for drawer items
		mliDrawerItems = new ArrayList<DrawerItem>();
		for (int i = 0; i < data.length; i++) {
			DrawerItem item = new DrawerItem(images[i], data[i]);
			mliDrawerItems.add(item);
		}
		initviews();
		// launch the zero position fragment os that is fragment one class
		FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
		tx.replace(R.id.main,
				Fragment.instantiate(MainActivity.this, fragments[0]));
		tx.commit();
	}

	/*
	 * The purpose of this method to initialize the layouts views
	 */
	private void initviews() {
		mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		mLlleftDrawer = (RelativeLayout) findViewById(R.id.left_drawer);
		mListDrawer = (ListView) findViewById(R.id.list_drawer);
		mLlMenuDrawer = (LinearLayout) findViewById(R.id.ll_menu_drawer);
		mListDrawer.setOnItemClickListener(this);
		// create the drawer list adapter class object and pass the arraylist
		// object into this class
		mDrawerListViewAdapter = new DrawerListViewAdapter(this, mliDrawerItems);
		// set the adapter object to list view
		mListDrawer.setAdapter(mDrawerListViewAdapter);
		mLlMenuDrawer.setOnClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view,
			final int position, long id) {
		mDrawer.setDrawerListener(new DrawerLayout.SimpleDrawerListener() {
			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
				FragmentTransaction tx = getSupportFragmentManager()
						.beginTransaction();
				tx.replace(R.id.main, Fragment.instantiate(MainActivity.this,
						fragments[position]));
				tx.commit();
			}
		});
		mDrawer.closeDrawer(mLlleftDrawer);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ll_menu_drawer: {
			// this case toolbar menu icon click to check the condition drawer
			// not open condtion is true then open the drawer
			if (!mDrawer.isDrawerOpen(mLlleftDrawer)) {
				mDrawer.openDrawer(mLlleftDrawer);
			}
		}
			break;
		default:
			break;
		}

	}

}
