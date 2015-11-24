package com.example.navigationdrawer;

public class DrawerItem {
	private int mIntDrawerImage;
	private String mStrItemName;

	public DrawerItem(int mIntDrawerImage, String mStrItemName) {
		this.mIntDrawerImage = mIntDrawerImage;
		this.mStrItemName = mStrItemName;
	}

	public int getmIntDrawerImage() {
		return mIntDrawerImage;
	}

	public void setmIntDrawerImage(int mIntDrawerImage) {
		this.mIntDrawerImage = mIntDrawerImage;
	}

	public String getmStrItemName() {
		return mStrItemName;
	}

	public void setmStrItemName(String mStrItemName) {
		this.mStrItemName = mStrItemName;
	}

}
