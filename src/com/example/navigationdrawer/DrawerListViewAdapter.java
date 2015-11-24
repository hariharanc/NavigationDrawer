package com.example.navigationdrawer;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DrawerListViewAdapter extends BaseAdapter {
	Context context;
	List<DrawerItem> rowItems;
	public DrawerListViewAdapter(Context context, List<DrawerItem> items) {
		this.context = context;
		this.rowItems = items;
	}

	/* private view holder class */
	private class ViewHolder {
		private ImageView mImgDrawerItem;
		private TextView mTxtTitle;

	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.drawer_item, null);
			holder = new ViewHolder();
			holder.mTxtTitle = (TextView) convertView
					.findViewById(R.id.txt_title);
			holder.mImgDrawerItem = (ImageView) convertView
					.findViewById(R.id.img_drawer_item);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		DrawerItem rowItem = (DrawerItem) getItem(position);

		holder.mTxtTitle.setText(rowItem.getmStrItemName());
		holder.mImgDrawerItem.setImageResource(rowItem.getmIntDrawerImage());

		return convertView;
	}

	@Override
	public int getCount() {
		return rowItems.size();
	}

	@Override
	public Object getItem(int position) {
		return rowItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return rowItems.indexOf(getItem(position));
	}
}