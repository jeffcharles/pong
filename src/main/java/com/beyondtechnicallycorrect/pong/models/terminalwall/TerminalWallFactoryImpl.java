package com.beyondtechnicallycorrect.pong.models.terminalwall;

import com.beyondtechnicallycorrect.pong.models.ball.Ball;
import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehaviour;
import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehaviours;
import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehavioursFactory;
import com.beyondtechnicallycorrect.pong.models.game.MatchStatePublisher;
import com.beyondtechnicallycorrect.pong.models.player.Player;
import com.beyondtechnicallycorrect.pong.models.position.Position;
import com.beyondtechnicallycorrect.pong.models.position.PositionFactory;
import com.google.inject.Inject;

final class TerminalWallFactoryImpl implements TerminalWallFactory {

	private final PositionFactory m_positionFactory;
	private final CollisionBehavioursFactory m_collisionBehavioursFactory;
	private final MatchStatePublisher m_matchStatePublisher;
	
	@Inject
	public TerminalWallFactoryImpl(
			PositionFactory positionFactory,
			CollisionBehavioursFactory collisionBehavioursFactory,
			MatchStatePublisher matchStatePublisher
		) {
		
		m_positionFactory = positionFactory;
		m_collisionBehavioursFactory = collisionBehavioursFactory;
		m_matchStatePublisher = matchStatePublisher;
	}
	
	@Override
	public TerminalWall create(
			int x1,
			int x2,
			int y1,
			int y2,
			Player player
		) {
		
		Position pos = m_positionFactory.create(x1, x2, y1, y2);
		InternalTerminalWall internalTerminalWall =
				new InternalTerminalWallImpl(pos, player);
		
		CollisionBehaviours cb = m_collisionBehavioursFactory.create();
		CollisionBehaviour<Ball> bcb =
				new BallCollisionBehaviour(
						internalTerminalWall,
						m_matchStatePublisher
					);
		cb.addBehaviour(bcb);
		
		TerminalWall wall = new TerminalWallImpl(internalTerminalWall, cb);
		return wall;
	}

}
