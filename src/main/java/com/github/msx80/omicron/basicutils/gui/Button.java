package com.github.msx80.omicron.basicutils.gui;

import com.github.msx80.omicron.api.Sys;
import com.github.msx80.omicron.basicutils.Colors;
import com.github.msx80.omicron.basicutils.gui.drawers.Background;
import com.github.msx80.omicron.basicutils.gui.drawers.Backgrounded;
import com.github.msx80.omicron.basicutils.gui.drawers.OutlineRectangle;
import com.github.msx80.omicron.basicutils.text.TextDrawer;

public class Button extends BasicButton implements Texted, Backgrounded
{
	private Background bg =new OutlineRectangle(Colors.BLUE, Colors.GREEN);
	private String text;
	private TextDrawer font;
	private Sys sys;

	public Button(Sys sys, String text, TextDrawer font, Event onClick)
	{
		super(font.width(text)+4, font.height()+4, onClick);
		this.text = text;
		this.font = font;
		this.sys = sys;
	}
	
	@Override
	public void draw() {
		bg.draw(sys, 0, 0, w, h);
		font.print(text, 2,2);
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public void setText(String text) {
		this.text = text;
		
		this.setSize(font.width(text)+4, font.height()+4);
	}

	public Background getBg() {
		return bg;
	}

	public Button setBg(Background bg) {
		this.bg = bg;
		return this;
	}
	
	
}
