package com.beyondtechnicallycorrect.pong.models.ball;

import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehaviour;
import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;
import com.beyondtechnicallycorrect.pong.models.terminalwall.TerminalWall;

final class TerminalWallCollisionBehaviour implements CollisionBehaviour<TerminalWall> {

	private final InternalBall m_internalBall;
	
	public TerminalWallCollisionBehaviour(
			InternalBall internalBall
		) {
		
		m_internalBall = internalBall;
	}
	
	@Override
	public Class<TerminalWall> getTypeCollidedWith() {
		return TerminalWall.class;
	}

	@Override
	public void collide(Placeable collidedWith) {
		m_internalBall.setVelocity(0, 1, 0, 1);
	}

}
