package com.github.msx80.omicron.basicutils;

import com.github.msx80.omicron.api.Sys;
import com.github.msx80.omicron.basicutils.gui.drawers.Background;

public class NinePatch implements Background {

	private int startx;
	private int starty;
	private int w;
	private int h;
	private int left;
	private int right;
	private int top;
	private int bottom;
	private int sheet;

	public NinePatch(int sheet, int startx, int starty, int w, int h, int left, int right, int top, int bottom) 
	{
		this.sheet = sheet;
		this.startx = startx;
		this.starty = starty;
		this.w = w;
		this.h = h;
		this.left = left;
		this.right = right;
		this.top = top;
		this.bottom = bottom;
	}

	
	public void draw(int px, int py, int pw, int ph)
	{
		
		// top left
		Sys.draw(sheet, px, py, startx, starty, left, top, 0, 0);
		// top right
		Sys.draw(sheet, px+pw-right, py, startx+w-right, starty, right, top, 0, 0);
		// bottom left
		Sys.draw(sheet, px, py+ph-bottom, startx, starty+h-bottom, left, bottom, 0, 0);
		// bottom right
		Sys.draw(sheet, px+pw-right, py+ph-bottom, startx+w-right, starty+h-bottom, right, bottom, 0, 0);
		
		
		// top row
		drawHrow(px+left, py, startx+left, starty, pw-left-right , top, w-left-right);
		// bottom row
		drawHrow(px+left, py+ph-bottom, startx+left, starty+h-bottom, pw-left-right , bottom, w-left-right);
		// left column
		drawVrow( px, py+top, startx, starty+top, left , ph-top-bottom, h-top-bottom);
		// right column
		drawVrow( px+pw-right, py+top, startx+w-right, starty+top, right , ph-top-bottom, h-top-bottom);
				
		 
		drawCenter( px+left, py+top, pw-left-right, ph-top-bottom, startx+left, starty+top, w-left-right, h-top-bottom);
	}

	private void drawCenter(int x, int y, int w, int h, int srcx, int srcy, int srcw, int srch) {
		
		while(h>0)
		{
			int dh = Math.min(srch, h);
			drawHrow( x, y, srcx, srcy, w, dh, srcw);
			h-=dh;
			y+=dh;
		}
		
	}


	private void drawVrow(int x, int y, int srcx, int srcy, int w, int h, int barH) 
	{
		Sys.draw(sheet, x, y, srcx, srcy, w, Math.min(h,  barH), 0, 0);
		h -= barH;
		if(h>0)
		{
			drawVrow(x, y+barH, srcx, srcy, w, h, barH);
		}
		
	}
	private void drawHrow( int x, int y, int srcx, int srcy, int w, int h, int barW) 
	{
		Sys.draw(sheet, x, y, srcx, srcy, Math.min(w,  barW), h, 0, 0);
		w -= barW;
		if(w>0)
		{
			drawHrow( x+barW, y, srcx, srcy, w, h, barW);
		}
		
	}


	@Override
	public int getMargin() {
		
		return left;
	}
	
}
