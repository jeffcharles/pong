package com.beyondtechnicallycorrect.pong.models.collision;

import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;

public interface Collidable extends Placeable {
	
	public void collide(Placeable objectCollidedWith);

}
