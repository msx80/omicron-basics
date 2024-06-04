package com.github.msx80.omicron.basicutils.text.richtext;

import com.github.msx80.omicron.api.Sys;
import com.github.msx80.omicron.basicutils.text.TextDrawer;

public interface RichtextDrawingContext {

	TextDrawer getDefaultTextDrawer();
	Sys getSys();
	
	public static RichtextDrawingContext of(TextDrawer td, Sys sys)
	{
		return new RichtextDrawingContext() {
			
			@Override
			public Sys getSys() {
				return sys;
			}
			
			@Override
			public TextDrawer getDefaultTextDrawer() {
				return td;
			}
		};
	}
}
