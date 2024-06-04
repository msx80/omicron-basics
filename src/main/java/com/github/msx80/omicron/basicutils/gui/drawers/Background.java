package com.github.msx80.omicron.basicutils.gui.drawers;

import com.github.msx80.omicron.api.Sys;

public interface Background 
{
	public int getMargin();
	public void draw(Sys sys, int x, int y, int w, int h);
}
