package com.github.msx80.omicron.basicutils;

import com.github.msx80.omicron.api.Sys;

public class SpriteSheet {

	int spriteWidth;
	int spriteHeight;
	int spritesPerRow;
	
	public SpriteSheet(int spriteWidth, int spriteHeight, int spritesPerRow) {
		super();
		this.spriteWidth = spriteWidth;
		this.spriteHeight = spriteHeight;
		this.spritesPerRow = spritesPerRow;
	}
	
	public void draw(Sys sys, int sheet, int x, int y, int sprite, int rotate, int flip)
	{
		int spritex = (sprite % spritesPerRow) * spriteWidth;
		int spritey = (sprite / spritesPerRow) * spriteHeight;
		
		sys.draw(sheet, x, y, spritex, spritey, spriteWidth, spriteHeight, rotate, flip);
	}

}
