package com.beyondtechnicallycorrect.pong.models.collision;

import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;

public interface WallCollisionBehaviour {
	
	public void collide(
			MutableOnCollision internalModel,
			Placeable collidedWith,
			AdjustVelocityDelegate adjustVelocityDelegate
		);

}
