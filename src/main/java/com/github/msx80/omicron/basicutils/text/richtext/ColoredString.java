package com.github.msx80.omicron.basicutils.text.richtext;

import com.github.msx80.omicron.api.Sys;
import com.github.msx80.omicron.basicutils.text.TextDrawer;
import com.github.msx80.omicron.basicutils.text.TextDrawer.Align;

public class ColoredString implements RichtextItem {
	public final int color;
	public final String text;
	
	public ColoredString(int color, String text) {
		this.color = color;
		this.text = text;
	}

	@Override
	public String toString() {
		return "["+color + "]" + text;
	}

	@Override
	public int width(TextDrawer ctx) 
	{
		return ctx.width(this.text);
	}

	@Override
	public int draw(int sx, int sy, TextDrawer ctx) {
		int w = 0;
		Sys.color(this.color);
		
		w = ctx.width(this.text);
		ctx.print(this.text,sx,sy, Align.LEFT);
		return w;
	}

	@Override
	public int height(TextDrawer ctx) {
		return ctx.height();
	}
	
	
}
