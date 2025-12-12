package com.github.msx80.omicron.basicutils;

import java.math.BigInteger;

public class Colors 
{
	public static final int BLACK = from(0,0,0);
	public static final int WHITE = from(255,255,255);
	public static final int RED = from(255,0,0);
	public static final int GREEN = from(0,255,0);
	public static final int BLUE = from(0,0,255);
	
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
