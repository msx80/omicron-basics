package com.github.msx80.omicron.basicutils.gui;

import com.github.msx80.omicron.api.Sys;

import com.github.msx80.omicron.basicutils.Colors;
import com.github.msx80.omicron.basicutils.text.TextDrawer;
import com.github.msx80.omicron.basicutils.text.TextDrawerVariable;

public class Label extends BaseWidget implements Texted {

	private String text;
	private TextDrawer font;
	private int color;

	public Label(String text, int color)
	{
		this(text, color, TextDrawerVariable.DEFAULT);
	}

	public Label(String text, int color, TextDrawer font)
	{
		super(font.width(text), font.height());
		this.text = text;
		this.font = font;
		this.color = color;
	}
	
	@Override
	public void draw() {
		Sys.color(this.color);
		font.print(text, 0,0);
		Sys.color(Colors.WHITE);
	}

	public Label setText(String string) {
		this.text = string;
		return this;
		
	}

	@Override
	public String getText() {
		
		return text;
	}

}
