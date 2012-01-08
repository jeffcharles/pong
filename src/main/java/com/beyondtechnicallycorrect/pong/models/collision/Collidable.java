package com.beyondtechnicallycorrect.pong.models.collision;

import com.beyondtechnicallycorrect.pong.models.placeable.Overlappable;
import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;
import com.beyondtechnicallycorrect.pong.models.velocity.Movable;

public interface Collidable extends Placeable, Overlappable, Movable {

	public void collide(Placeable objectCollidedWith);
	
}
