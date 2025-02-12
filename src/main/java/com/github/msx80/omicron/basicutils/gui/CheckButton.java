package com.github.msx80.omicron.basicutils.gui;

import com.github.msx80.omicron.basicutils.Colors;
import com.github.msx80.omicron.basicutils.ShapeDrawer;
import com.github.msx80.omicron.basicutils.gui.drawers.Background;
import com.github.msx80.omicron.basicutils.gui.drawers.Backgrounded;
import com.github.msx80.omicron.basicutils.gui.drawers.OutlineRectangle;
import com.github.msx80.omicron.basicutils.text.TextDrawer;
import com.github.msx80.omicron.basicutils.text.TextDrawerVariable;

public class CheckButton  extends BasicButton implements Texted, Backgrounded
{
	private Background bg;
	private String text;
	private TextDrawer font;
	private boolean checked = false;

	public CheckButton(String text, TextDrawer font, Event onClick, Background bg)
	{
		super(10+font.width(text)+bg.getMargin()*2, font.height()+bg.getMargin()*2, null);
		this.bg = bg;
		this.text = text;
		this.font = font;
		this.setOnClick(e -> {this.toggle(); if(onClick!=null) onClick.event(e);});
	}
	
	private void toggle() {
		this.checked = ! this.checked;
		
	}

	public CheckButton(String text, Event onClick)
	{
		this(text, TextDrawerVariable.DEFAULT, onClick);
	}
	public CheckButton(String text, TextDrawer font, Event onClick)
	{
		this(text, font, onClick, new OutlineRectangle(Colors.BLUE, Colors.GREEN));
	}
	
	public CheckButton(String text, Event onClick, Background bg) {
		this(text, TextDrawerVariable.DEFAULT, onClick, bg);
	}

	@Override
	public void draw() {
		bg.draw(0, 0, w, h);
		font.print(text, 10+bg.getMargin(), bg.getMargin());
		ShapeDrawer.outline( bg.getMargin(), bg.getMargin(), font.height(), font.height(), 0, Colors.RED);
		if(this.checked )
		{
			ShapeDrawer.rect(1+bg.getMargin(), 1+bg.getMargin(), 4, 4, 0, Colors.from(255, 200, 200));
		}
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public CheckButton setText(String text) {
		this.text = text;
		
		int marg = bg.getMargin()*2;
		this.size(font.width(text)+marg, font.height()+marg);
		return this;
	}

	public Background getBg() {
		return bg;
	}

	public CheckButton setBg(Background bg) {
		this.bg = bg;
		this.w = font.width(text)+bg.getMargin()*2;
		this.h = font.height()+bg.getMargin()*2;
		invalidate();
		return this;
	}

	public boolean isChecked() {
		return checked;
	}

	public CheckButton setChecked(boolean checked) {
		this.checked = checked;
		return this;
	}
	
	
}
