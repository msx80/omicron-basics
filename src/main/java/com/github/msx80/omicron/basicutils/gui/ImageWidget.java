package com.github.msx80.omicron.basicutils.gui;

import com.github.msx80.omicron.basicutils.gui.drawers.Background;

public class ImageWidget extends BaseWidget {

	private Background img;

	public ImageWidget(Background img, int w, int h) {
		super(w, h);
		this.img = img;
	}

	@Override
	public void draw() {
		img.draw( 0, 0, w, h);
		
	}

	public Background getImg() {
		return img;
	}

	public void setImg(Background img) {
		this.img = img;
	}
	
	

}
