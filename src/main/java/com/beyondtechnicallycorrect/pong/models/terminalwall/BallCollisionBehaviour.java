package com.beyondtechnicallycorrect.pong.models.terminalwall;

import com.beyondtechnicallycorrect.pong.models.ball.Ball;
import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehaviour;
import com.beyondtechnicallycorrect.pong.models.game.MatchStatePublisher;
import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;
import com.beyondtechnicallycorrect.pong.models.player.Player;

final class BallCollisionBehaviour implements CollisionBehaviour<Ball> {

	private final InternalTerminalWall m_internalTerminalWall;
	private final MatchStatePublisher m_matchStatePublisher;
	
	public BallCollisionBehaviour(
			InternalTerminalWall internalTerminalWall,
			MatchStatePublisher matchStatePublisher
		) {
		
		m_internalTerminalWall = internalTerminalWall;
		m_matchStatePublisher = matchStatePublisher;
	}
	
	@Override
	public Class<Ball> getTypeCollidedWith() {
		return Ball.class;
	}

	@Override
	public void collide(Placeable collidedWith) {
		Player winningPlayer = m_internalTerminalWall.getPlayer();
		m_matchStatePublisher.publishMatchEnding(winningPlayer);
	}

}
