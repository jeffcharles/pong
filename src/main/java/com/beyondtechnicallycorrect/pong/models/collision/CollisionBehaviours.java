package com.beyondtechnicallycorrect.pong.models.collision;

import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;

public interface CollisionBehaviours {
	
	public void addBehaviour(CollisionBehaviour<? extends Placeable> behaviour);
	public void collide(Placeable collidedWith);

}
