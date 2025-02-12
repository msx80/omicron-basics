package com.github.msx80.omicron.basicutils.text.richtext;

import com.github.msx80.omicron.basicutils.text.TextDrawer;

public interface RichtextItem 
{
	int width(TextDrawer ctx);
	int height(TextDrawer ctx);
	int draw(int sx, int sy, TextDrawer ctx);
}
