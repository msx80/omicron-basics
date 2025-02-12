package com.github.msx80.omicron.basicutils.gui.drawers;

import com.github.msx80.omicron.basicutils.SpriteSheet;

public class SpriteBackground implements Background {

	
	private SpriteSheet sp;
	private int spriteNum;
	private int sheetNum;
	
	public SpriteBackground(SpriteSheet sp, int spriteNum, int sheetNum) {
		super();
		this.sp = sp;
		this.spriteNum = spriteNum;
		this.sheetNum = sheetNum;
	}

	@Override
	public int getMargin() {
		
		return 0;
	}

	@Override
	public void draw(int x, int y, int w, int h) {
		sp.draw(sheetNum , x, y, spriteNum, 0,0);

	}

}
