package com.github.msx80.omicron.basicutils.gui;

import com.github.msx80.omicron.api.Sys;
import com.github.msx80.omicron.basicutils.Colors;
import com.github.msx80.omicron.basicutils.gui.drawers.Background;
import com.github.msx80.omicron.basicutils.gui.drawers.Backgrounded;
import com.github.msx80.omicron.basicutils.gui.drawers.OutlineRectangle;
import com.github.msx80.omicron.basicutils.text.TextDrawer;

public class Button extends BasicButton implements Texted, Backgrounded
{
	private Background bg;
	private String text;
	private TextDrawer font;
	private Sys sys;

	public Button(Sys sys, String text, TextDrawer font, Event onClick, Background bg)
	{
		super(font.width(text)+bg.getMargin()*2, font.height()+bg.getMargin()*2, onClick);
		this.bg = bg;
		this.text = text;
		this.font = font;
		this.sys = sys;
	}
	
	public Button(Sys sys, String text, TextDrawer font, Event onClick)
	{
		this(sys, text, font, onClick, new OutlineRectangle(Colors.BLUE, Colors.GREEN));
	}
	
	@Override
	public void draw() {
		bg.draw(sys, 0, 0, w, h);
		font.print(text, bg.getMargin(), bg.getMargin());
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public void setText(String text) {
		this.text = text;
		
		int marg = bg.getMargin()*2;
		this.setSize(font.width(text)+marg, font.height()+marg);
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
