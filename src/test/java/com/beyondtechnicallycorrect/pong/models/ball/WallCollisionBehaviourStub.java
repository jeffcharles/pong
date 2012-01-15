package com.beyondtechnicallycorrect.pong.models.ball;

import com.beyondtechnicallycorrect.pong.models.collision.AdjustVelocityDelegate;
import com.beyondtechnicallycorrect.pong.models.collision.MutableOnCollision;
import com.beyondtechnicallycorrect.pong.models.collision.WallCollisionBehaviour;
import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;

final class WallCollisionBehaviourStub implements WallCollisionBehaviour {

	@Override
	public void collide(
			MutableOnCollision internalModel,
			Placeable collidedWith,
			AdjustVelocityDelegate adjustVelocityDelegate
		) {
		
		// TODO Auto-generated method stub
	}

}
