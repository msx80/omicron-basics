package com.github.msx80.omicron.basicutils.anim;

import java.util.Optional;
import java.util.stream.Stream;

public class Parallel extends Animation {

	private IAnimation a1;
	private IAnimation a2;

	public Parallel(Animation a1, Animation a2) {
		super(Easing.LINEAR, Math.max(a1.ttl, a2.ttl));
		this.a1 = a1;
		this.a2 = a2;
	}

	@Override
	public void update(double position) {
		if(!a1.finished()) a1.advance();
		if(!a2.finished()) a2.advance();
	}

	public static Animation of(Animation... anims)
	{
		Optional<Animation> x = Stream.of(anims).reduce(Parallel::new);
		if(x.isPresent()) return x.get();
		return null;
	}
	
}
