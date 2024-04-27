package com.github.msx80.omicron.basicutils.gui;


/**
 * Same as AbstractList but elements can have different heights.
 * Is a bit less performant and needs to be informed of changes via notifyItemChanges()
 * 
 *
 * @param <T>
 */
public abstract class VariableHeightAbstractList<T> extends AbstractList<T> {

	
	/**
	 * This caches has info about index and starting position for drawing from a particular starting point in the vertical direction (forY)
	 * (and also for a particular height).
	 * This is becouse calculating from which index to start drawing would require traversing the whole list
	 * to get the height of all items, which is expensive expecially at the bottom of the list.
	 * Since we can expect this to be drawn hundreds of times with the same values, it's good to cache them.
	 * 
	 *  This should be invalidated on:
	 *  - scrolling (automatic since PartialDrawable gives the position)
	 *  - resizing 
	 *  - addition/removal/height change of items (for which is responsible the child class, see notifyItemChanges)
	 *
	 */
	public class IndexCache {
		int forY; // for which y starting position this cache is valid.
		int forHeight; // for which height this cache is valid.
		int startIdx; // first index to be drawn
		int endIdx; // last index to be draw
		int startIdxPosY; // actual position where to draw first index.
		
		
		
		public IndexCache(int forY, int forHeight, int startIdx, int endIdx, int startIdxPosY) {
			super();
			set(forY, forHeight, startIdx, endIdx, startIdxPosY);
		}



		private void set(int forY, int forHeight, int startIdx, int endIdx, int startIdxPosY) {
			this.forY = forY;
			this.forHeight = forHeight;
			this.startIdx = startIdx;
			this.endIdx = endIdx;
			this.startIdxPosY = startIdxPosY;
		}

		

		public IndexCache() {
			invalidate();
		}



		private void invalidate() {
			// ensure it's never valid
			forY = -1;
			forHeight = -1;
		}



		boolean isValid(int y, int h)
		{
			return y == forY && h == forHeight;
		}



		@Override
		public String toString() {
			return "IndexCache [forY=" + forY + ", forHeight=" + forHeight + ", startIdx=" + startIdx + ", endIdx="
					+ endIdx + ", startIdxPosY=" + startIdxPosY + "]";
		}
		
		
		
	}
	
	private int currentTotalHeight;
	private final IndexCache idxCache = new IndexCache();
	private int[] heights;
	
	public VariableHeightAbstractList(int w) {
		super(w, 10);
	}

	protected void init()
	{
		currentTotalHeight = calcTotalHeight();
		this.setSize(w, currentTotalHeight);
	}
	
	private int calcTotalHeight() {
		int res = 0;
		heights = new int[itemsCount()];
		for (int i = 0; i < heights.length ; i++) {
			int h = itemHeight(i);
			heights[i] = h;
			res = res + h;
		}
		return res;
	}

	@Override
	public void draw() {
		drawItems(0, Integer.MAX_VALUE, 0);
	}
	
	
	@Override
	public void draw(int fromx, int fromy, int width, int height) {
		if(!idxCache.isValid(fromy, height))
		{
			calcIdxCache(fromy, height);
		}
		drawItems(idxCache.startIdx, idxCache.endIdx, idxCache.startIdxPosY);
	}



	private void calcIdxCache(int fromy, int height)
	{
		int spaceLeft = fromy;
		int idx = 0;
		while(idx<itemsCount())
		{
			int ih = heights[idx];
			if(spaceLeft<ih) break;
			spaceLeft -= ih;
			idx++;
		}
		int startIdx = idx;
		int startPosY = fromy-spaceLeft;
		
		spaceLeft+=height;
		while(idx<itemsCount())
		{
			int ih = heights[idx];
			idx++; // increment before to include partial last element
			if(spaceLeft<ih) break;
			spaceLeft -= ih;
		}
		int endIdx = idx;
		
		
		idxCache.set(fromy, height, startIdx, endIdx, startPosY);
		//System.out.println(i);
	}

	@Override
	public void click(int x, int y) {
		int ic = itemsCount();
		int idx = 0;
		while(true)
		{
			int ih = heights[idx];
			if (y< ih) break;
			idx++;
			y-=ih;
			if(idx>=ic) return; // outside of the list
		}
		clicked(idx);
	}

	
	private void drawItems(int startIdx, int endIdx, int startY) {
		int siz = itemsCount();
		if(siz>endIdx)
		{
			siz = endIdx;
		}
		int s = Math.max(0, startIdx);
		
		boolean odd = startIdx % 2 == 0;
		int curY = startY;
		for (int i = s; i < siz; i++) 
		{
			drawItem(i, 0, curY, odd, heights[i]);
			curY = curY + heights[i];
			odd = !odd;
		}
	}

	public abstract void drawItem(int idx, int x, int y, boolean odd, int itemHeight);
	
	public abstract int itemHeight(int idx);
	
	
	/**
	 * Notify the list engine that items were added, removed or that they changed height.
	 * This triggers recomputing heights and indexes so call it once after you're done with
	 * all modifications.
	 */
	public void notifyItemChanges()
	{
		idxCache.invalidate();
		currentTotalHeight = calcTotalHeight();
		this.setSize(w, currentTotalHeight);
	}
}
