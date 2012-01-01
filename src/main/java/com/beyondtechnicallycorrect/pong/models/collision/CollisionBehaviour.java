package com.beyondtechnicallycorrect.pong.models.collision;

import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;

public interface CollisionBehaviour<T extends Placeable> {
	
	public Class<T> getTypeCollidedWith();
	public void collide(Placeable collidedWith);

}
