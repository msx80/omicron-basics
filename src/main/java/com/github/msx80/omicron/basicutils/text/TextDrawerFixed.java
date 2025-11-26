package com.github.msx80.omicron.basicutils.text;

import java.nio.charset.Charset;

import com.github.msx80.omicron.api.Sys;

/**
 * TextDrawer that implements monospaced font. The stepping value controls how much to advance for each character. 
 *
 */
public class TextDrawerFixed implements TextDrawer {
		
	private static final Charset charset = TextDrawer.getCharset();
	
	private final int sheetNum;
	private final int charWidth;
	private final int charHeight;
	private final int stepping;

	public static final TextDrawerFixed DEFAULT = new TextDrawerFixed( -1, 6, 6, 6);
	
	
	public TextDrawerFixed(int sheetNum, int charWidth, int charHeight, int stepping) {
		super();
		this.sheetNum = sheetNum;
		this.charWidth = charWidth;
		this.charHeight = charHeight;
		this.stepping = stepping;
	}
	
	@Override
	public int print(String text, int x, int y, Align align)
	{
		int dx = 0;
		if(align == Align.CENTER)
		{
			dx = -width(text)/2;
		}
		else if(align == Align.RIGHT)
		{
			dx = -width(text);
		}
		
		return print(text, x+dx, y);
	}
	
	@Override
	public int print(String text, int x, int y)
	{
	
		byte[] b = text.getBytes(charset);
		for (int i = 0; i < b.length; i++) {
			int c = b[i];
			int dx = c % 16;
			int dy = c / 16;
			
			Sys.draw(sheetNum, x+i*stepping, y, dx*charWidth, dy*charHeight, charWidth, charHeight, 0, 0);
		
		}
		return b.length * stepping;
	}
	@Override
	public int width(String text)
	{
		return text.length() * stepping;
	}
	@Override
	public int height() {
		return charHeight;
	}
	public int getCharHeight() {
		return charHeight;
	}
	public int getStepping() {
		return stepping;
	}
	
	
}
