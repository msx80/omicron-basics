package com.github.msx80.omicron.basicutils.text.richtext;

import com.github.msx80.omicron.api.Sys;
import com.github.msx80.omicron.basicutils.text.TextDrawer;

public class Icon implements RichtextItem {

	int sheetNum;
	int srcx;
	int srcy;
	int w;
	int h;
	
	public Icon(int sheetNum, int srcx, int srcy, int w, int h) {
		super();
		this.sheetNum = sheetNum;
		this.srcx = srcx;
		this.srcy = srcy;
		this.w = w;
		this.h = h;
	}

	@Override
	public int width(TextDrawer ctx) {
		return w;
	}

	@Override
	public int draw(int sx, int sy, TextDrawer ctx) {
		Sys.draw(sheetNum, sx, sy, srcx, srcy, w, h, 0, 0);
		return w;
	}

	@Override
	public int height(TextDrawer ctx) {
		return h;
	}

}
