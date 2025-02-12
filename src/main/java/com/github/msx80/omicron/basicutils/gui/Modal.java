package com.github.msx80.omicron.basicutils.gui;

import com.github.msx80.omicron.api.Sys;
import com.github.msx80.omicron.basicutils.Colors;
import com.github.msx80.omicron.basicutils.gui.drawers.AlphaColor;
import com.github.msx80.omicron.basicutils.gui.drawers.Background;
import com.github.msx80.omicron.basicutils.gui.drawers.Backgrounded;


/**
 * A container open modally, ie it prevents interaction with the rest
 * of the widgets until it is removed.
 * It works by exploiting the fact that the last widget added is the first
 * processed.
 *
 */
public class Modal extends ManagedParentWidget implements Clickable, Backgrounded
{

	private Background bg = new AlphaColor(0, Colors.from(0, 0, 0, 64));

	public Modal(int screenWidth, int screenHeight) {
		super(screenWidth, screenHeight);
	}
//	public Modal(Sys sys) {
//		super(sys, Integer.MAX_VALUE, Integer.MAX_VALUE);
//	}

	@Override
	public boolean isInside(int px, int py) {
		// a modal is always fullscreen
		return true;
	}

	@Override
	public void childInvalidated(Widget widget) {
		// nothing to do here
	}

	@Override
	public void draw() {
		bg.draw(0, 0, w, h); // this is really the whole screen
		Sys.color(Colors.WHITE);
		super.draw();
	}
	
	public void close()
	{
		if(parent!=null)
		{
			parent.remove(this);
		}
	}

	@Override
	public void click(int px, int py) {
		this.close();
	}

	public Background getBg() {
		return bg;
	}

	public Modal setBg(Background bg) {
		this.bg = bg;
		return this;
	}

	
	
}
