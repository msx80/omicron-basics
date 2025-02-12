package com.github.msx80.omicron.basicutils.gui.drawers;

public interface Background 
{
	
	public static final Background NONE = new Background() {

		@Override
		public int getMargin() {
			
			return 0;
		}

		@Override
		public void draw( int x, int y, int w, int h) {
					
		}
	};
	
	public int getMargin();
	public void draw(int x, int y, int w, int h);
}
