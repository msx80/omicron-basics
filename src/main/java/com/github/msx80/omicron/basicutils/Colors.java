package com.github.msx80.omicron.basicutils;

import java.math.BigInteger;

public class Colors 
{
	public static final int 	MAGENTA_OR_FUCHSIA = fromHex("FF00FF");
	public static final int 	SIENNA = fromHex("A0522D");
	public static final int 	DARKMAGENTA = fromHex("8B008B");
	public static final int 	CYAN_OR_AQUA = fromHex("00FFFF");
	public static final int 	OLIVEDRAB = fromHex("6B8E23");
	public static final int 	RED = fromHex("FF0000");
	public static final int 	ORANGERED = fromHex("FF4500");
	public static final int 	DARKRED = fromHex("8B0000");
	public static final int 	INDIANRED = fromHex("CD5C5C");
	public static final int 	PALEVIOLETRED = fromHex("DB7093");
	public static final int 	MEDIUMVIOLETRED = fromHex("C71585");
	public static final int 	ORCHID = fromHex("DA70D6");
	public static final int 	DARKORCHID = fromHex("9932CC");
	public static final int 	MEDIUMORCHID = fromHex("BA55D3");
	public static final int 	GOLD = fromHex("FFD700");
	public static final int 	BLANCHEDALMOND = fromHex("FFEBCD");
	public static final int 	GOLDENROD = fromHex("DAA520");
	public static final int 	PALEGOLDENROD = fromHex("EEE8AA");
	public static final int 	DARKGOLDENROD = fromHex("B8860B");
	public static final int 	BURLYWOOD = fromHex("DEB887");
	public static final int 	OLDLACE = fromHex("FEF0E3");
	public static final int 	BEIGE = fromHex("F5F5DC");
	public static final int 	ORANGE = fromHex("FFA500");
	public static final int 	DARKORANGE = fromHex("FF8C00");
	public static final int 	WHITESMOKE = fromHex("F5F5F5");
	public static final int 	PURPLE = fromHex("800080");
	public static final int 	REBECCAPURPLE = fromHex("663399");
	public static final int 	MEDIUMPURPLE = fromHex("9370DB");
	public static final int 	THISTLE = fromHex("D8BFD8");
	public static final int 	LIME = fromHex("00FF00");
	public static final int 	MEDIUMAQUAMARINE = fromHex("66CDAA");
	public static final int 	AQUAMARINE = fromHex("7FFFD4");
	public static final int 	AZURE = fromHex("F0FFFF");
	public static final int 	TURQUOISE = fromHex("40E0D0");
	public static final int 	PALETURQUOISE = fromHex("AFEEEE");
	public static final int 	DARKTURQUOISE = fromHex("00CED1");
	public static final int 	MEDIUMTURQUOISE = fromHex("48D1CC");
	public static final int 	MISTYROSE = fromHex("FFE4E1");
	public static final int 	CHARTREUSE = fromHex("7FFF00");
	public static final int 	CHOCOLATE = fromHex("D2691E");
	public static final int 	WHITE = fromHex("FFFFFF");
	public static final int 	ANTIQUEWHITE = fromHex("FAEBD7");
	public static final int 	FLORALWHITE = fromHex("FFFAF0");
	public static final int 	NAVAJOWHITE = fromHex("FFDEAD");
	public static final int 	GHOSTWHITE = fromHex("F8F8FF");
	public static final int 	BLUE = fromHex("0000FF");
	public static final int 	ALICEBLUE = fromHex("F0F8FF");
	public static final int 	SLATEBLUE = fromHex("6A5ACD");
	public static final int 	DARKSLATEBLUE = fromHex("483D8B");
	public static final int 	MEDIUMSLATEBLUE = fromHex("7B68EE");
	public static final int 	DARKBLUE = fromHex("00008B");
	public static final int 	ROYALBLUE = fromHex("4169E1");
	public static final int 	STEELBLUE = fromHex("4682B4");
	public static final int 	LIGHTSTEELBLUE = fromHex("B0CFDE");
	public static final int 	MEDIUMBLUE = fromHex("0000CD");
	public static final int 	POWDERBLUE = fromHex("B0E0E6");
	public static final int 	DODGERBLUE = fromHex("1E90FF");
	public static final int 	CORNFLOWERBLUE = fromHex("6495ED");
	public static final int 	CADETBLUE = fromHex("5F9EA0");
	public static final int 	LIGHTBLUE = fromHex("ADD8E6");
	public static final int 	MIDNIGHTBLUE = fromHex("191970");
	public static final int 	SKYBLUE = fromHex("87CEEB");
	public static final int 	DEEPSKYBLUE = fromHex("00BFFF");
	public static final int 	LIGHTSKYBLUE = fromHex("87CEFA");
	public static final int 	BISQUE = fromHex("FFE4C4");
	public static final int 	OLIVE = fromHex("808000");
	public static final int 	PEACHPUFF = fromHex("FFDAB9");
	public static final int 	LAVENDERBLUSH = fromHex("FFF0F5");
	public static final int 	KHAKI = fromHex("F0E68C");
	public static final int 	DARKKHAKI = fromHex("BDB76B");
	public static final int 	BLACK = fromHex("000000");
	public static final int 	FIREBRICK = fromHex("B22222");
	public static final int 	CORNSILK = fromHex("FFF8DC");
	public static final int 	PINK = fromHex("FFC0CB");
	public static final int 	DEEPPINK = fromHex("FF1493");
	public static final int 	LIGHTPINK = fromHex("FFB6C1");
	public static final int 	HOTPINK = fromHex("FF69B4");
	public static final int 	TEAL = fromHex("008080");
	public static final int 	CORAL = fromHex("FF7F50");
	public static final int 	LIGHTCORAL = fromHex("F08080");
	public static final int 	SEASHELL = fromHex("FFF5EE");
	public static final int 	MINTCREAM = fromHex("F5FFFA");
	public static final int 	PLUM = fromHex("DDA0DD");
	public static final int 	TAN = fromHex("D2B48C");
	public static final int 	DARKCYAN = fromHex("008B8B");
	public static final int 	LIGHTCYAN = fromHex("E0FFFF");
	public static final int 	GREEN = fromHex("008000");
	public static final int 	SEAGREEN = fromHex("2E8B57");
	public static final int 	DARKSEAGREEN = fromHex("8FBC8F");
	public static final int 	MEDIUMSEAGREEN = fromHex("3CB371");
	public static final int 	LIGHTSEAGREEN = fromHex("20B2AA");
	public static final int 	PALEGREEN = fromHex("98FB98");
	public static final int 	LIMEGREEN = fromHex("32CD32");
	public static final int 	DARKOLIVEGREEN = fromHex("556B2F");
	public static final int 	SPRINGGREEN = fromHex("00FF7F");
	public static final int 	MEDIUMSPRINGGREEN = fromHex("00FA9A");
	public static final int 	DARKGREEN = fromHex("006400");
	public static final int 	LAWNGREEN = fromHex("7CFC00");
	public static final int 	LIGHTGREEN = fromHex("90EE90");
	public static final int 	FORESTGREEN = fromHex("228B22");
	public static final int 	YELLOWGREEN = fromHex("9ACD32");
	public static final int 	LINEN = fromHex("FAF0E6");
	public static final int 	MOCCASIN = fromHex("FFE4B5");
	public static final int 	LEMONCHIFFON = fromHex("FFFACD");
	public static final int 	SALMON = fromHex("FA8072");
	public static final int 	DARKSALMON = fromHex("E9967A");
	public static final int 	LIGHTSALMON = fromHex("FFA07A");
	public static final int 	MAROON = fromHex("800000");
	public static final int 	CRIMSON = fromHex("DC143C");
	public static final int 	BROWN = fromHex("A52A2A");
	public static final int 	SADDLEBROWN = fromHex("8B4513");
	public static final int 	SANDYBROWN = fromHex("F4A460");
	public static final int 	ROSYBROWN = fromHex("BC8F8F");
	public static final int 	INDIGO = fromHex("4B0082");
	public static final int 	GAINSBORO = fromHex("DCDCDC");
	public static final int 	TOMATO = fromHex("FF6347");
	public static final int 	PAPAYAWHIP = fromHex("FFEFD5");
	public static final int 	LAVENDER = fromHex("E6E6FA");
	public static final int 	SILVER = fromHex("C0C0C0");
	public static final int 	WHEAT = fromHex("F5DEB3");
	public static final int 	VIOLET = fromHex("EE82EE");
	public static final int 	BLUEVIOLET = fromHex("8A2BE2");
	public static final int 	DARKVIOLET = fromHex("9400D3");
	public static final int 	PERU = fromHex("CD853F");
	public static final int 	HONEYDEW = fromHex("F0FFF0");
	public static final int 	YELLOW = fromHex("FFFF00");
	public static final int 	LIGHTGOLDENRODYELLOW = fromHex("FAFAD2");
	public static final int 	GREENYELLOW = fromHex("ADFF2F");
	public static final int 	LIGHTYELLOW = fromHex("FFFFE0");
	public static final int 	SNOW = fromHex("FFFAFA");
	public static final int 	GRAY_OR_GREY = fromHex("808080");
	public static final int 	SLATEGRAY_OR_SLATEGREY = fromHex("708090");
	public static final int 	DARKSLATEGRAY_OR_DARKSLATEGREY = fromHex("25383C");
	public static final int 	LIGHTSLATEGRAY_OR_LIGHTSLATEGREY = fromHex("778899");
	public static final int 	DARKGRAY_OR_DARKGREY = fromHex("A9A9A9");
	public static final int 	DIMGRAY_OR_DIMGREY = fromHex("696969");
	public static final int 	LIGHTGRAY_OR_LIGHTGREY = fromHex("D3D3D3");
	public static final int 	IVORY = fromHex("FFFFF0");
	public static final int 	NAVY = fromHex("000080");
	
	
	public static int from(int r, int g, int b, int a)
	{
		int color =  (r << 24) | (g << 16) | (b << 8) | a;
		return color;
	}
	public static int from(int r, int g, int b)
	{
		return from(r, g, b, 255);
	}
	
	public static String str(int c)
	{
		return Long.toString(c, 16); // format in hex
	}
	public static int fromHex(String string) {
		BigInteger b = new BigInteger(string, 16);
		return (b.intValue() << 8) | 255;
	}
	
	public static int alpha(int c)
	{
		return c & 0xFF;
	}
	
	public static int red(int c)
	{
		return ( c >> 24 ) & 0xFF;
	}
	
	public static int green(int c)
	{
		return ( c >> 16 ) & 0xFF;
	}
	
	public static int blue(int c)
	{
		return ( c >> 8 ) & 0xFF;
	}
	
	
	public static void main(String[] args)
	{
		System.out.println(Colors.BLACK);
		System.out.println(Colors.RED);
	}
	
	public static double colorDistance(int c1, int c2)
	{
		
	    int red1 = red(c1);
	    int red2 = red(c2);
	    int rmean = (red1 + red2) >> 1;
	    int r = red1 - red2;
	    int g = green(c1) - green(c2);
	    int b = blue(c1) - blue(c2);
	    return (((512+rmean)*r*r)>>8) + 4*g*g + (((767-rmean)*b*b)>>8);
		/*
	    int r = red(c1) - red(c2);
	    int g = green(c1) - green(c2);
	    int b = blue(c1) - blue(c2);
	    return r^2 + b^2 + g^2;
	    */
	}
	
	public static int nearest(int color, int[] candidates)
	{
		double min = Double.MAX_VALUE;
		int idx = -1;
		for (int i = 0; i < candidates.length; i++) {
			double dist = colorDistance(color, candidates[i]);
			if(dist<min)
			{
				min = dist;
				idx = i;
			}
		}
		return idx;
	}
	
}
