package com.github.msx80.omicron.basicutils.text;

import java.nio.charset.Charset;

/**
 * Draws a text on the screen.
 * 
 */
public interface TextDrawer {
	
	public static enum Align {LEFT, CENTER, RIGHT};

	int print(String text, int x, int y, Align align);

	int print(String text, int x, int y);

	int width(String text);
	
	int height();
		
	static Charset getCharset() {

		// note: isSupported not available on TeaVm
		 Charset acharset;
		 try {
			acharset  = Charset.forName("Cp437");
		 } catch (Exception e) {
			 System.out.println("Cp437 not available, using default charset instead");
			acharset = Charset.defaultCharset();
		 }
		 return acharset;
	
	
	}

}