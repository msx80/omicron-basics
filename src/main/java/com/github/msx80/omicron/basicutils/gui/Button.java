package com.github.msx80.omicron.basicutils.gui;

import com.github.msx80.omicron.api.Sys;
import com.github.msx80.omicron.basicutils.Colors;
import com.github.msx80.omicron.basicutils.gui.drawers.Background;
import com.github.msx80.omicron.basicutils.gui.drawers.Backgrounded;
import com.github.msx80.omicron.basicutils.gui.drawers.OutlineRectangle;
import com.github.msx80.omicron.basicutils.text.TextDrawer;
import com.github.msx80.omicron.basicutils.text.TextDrawerVariable;

public class Button extends BasicButton implements Texted, Backgrounded
{
	private Background bg;
	private String text;
	private TextDrawer font;

	public Button(String text, TextDrawer font, Event onClick, Background bg)
	{
		super(font.width(text)+bg.getMargin()*2, font.height()+bg.getMargin()*2, onClick);
		this.bg = bg;
		this.text = text;
		this.font = font;
	}
	
	public Button(String text, TextDrawer font, Event onClick)
	{
		this(text, font, onClick, new OutlineRectangle(Colors.BLUE, Colors.GREEN));
	}
	
	public Button(String text, Event onClick)
	{
		this(text, TextDrawerVariable.DEFAULT, onClick, new OutlineRectangle(Colors.BLUE, Colors.GREEN));
	}
	
	@Override
	public void draw() {
		bg.draw( 0, 0, w, h);
		font.print(text, bg.getMargin(), bg.getMargin());
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public Button setText(String text) {
		this.text = text;
		
		int marg = bg.getMargin()*2;
		this.size(font.width(text)+marg, font.height()+marg);
		return this;
	}

	public Background getBg() {
		return bg;
	}

	public Button setBg(Background bg) {
		this.bg = bg;
		this.w = font.width(text)+bg.getMargin()*2;
		this.h = font.height()+bg.getMargin()*2;
		invalidate();
		return this;
	}
	
	
}
