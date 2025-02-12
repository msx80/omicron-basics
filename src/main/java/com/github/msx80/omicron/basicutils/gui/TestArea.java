package com.github.msx80.omicron.basicutils.gui;

import com.github.msx80.omicron.basicutils.Colors;
import com.github.msx80.omicron.basicutils.ShapeDrawer;

public class TestArea extends BaseWidget {

	public TestArea(int w, int h) {
		super(w, h);
	}

	@Override
	public void draw() {
		ShapeDrawer.rect( 0, 0, w, h, 0, Colors.BLUE);
		ShapeDrawer.outline( 0, 0, w, h, 0, Colors.RED);

	}

}
