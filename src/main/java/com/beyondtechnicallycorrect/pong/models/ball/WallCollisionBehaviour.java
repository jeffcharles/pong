package com.beyondtechnicallycorrect.pong.models.ball;

import com.beyondtechnicallycorrect.pong.models.collision.AdjustVelocityDelegate;
import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehaviour;
import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;
import com.beyondtechnicallycorrect.pong.models.wall.Wall;

final class WallCollisionBehaviour implements CollisionBehaviour<Wall> {

	private final com.beyondtechnicallycorrect.pong.models.collision.WallCollisionBehaviour m_behaviour;
	private final AdjustVelocityDelegate m_adjustVelocityDelegate;
	private final InternalBall m_internalBall;
	
	public WallCollisionBehaviour(
			com.beyondtechnicallycorrect.pong.models.collision.WallCollisionBehaviour behaviour,
			AdjustVelocityDelegate adjustVelocityDelegate,
			InternalBall internalBall
		) {
		
		m_behaviour = behaviour;
		m_adjustVelocityDelegate = adjustVelocityDelegate;
		m_internalBall = internalBall;
	}
	
	@Override
	public Class<Wall> getTypeCollidedWith() {
		return Wall.class;
	}

	@Override
	public void collide(Placeable collidedWith) {
		m_behaviour.collide(
				m_internalBall,
				collidedWith,
				m_adjustVelocityDelegate
			);
	}

}
