package com.beyondtechnicallycorrect.pong.models.terminalwall;

import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehaviours;
import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehavioursFactory;
import com.beyondtechnicallycorrect.pong.models.player.Player;
import com.beyondtechnicallycorrect.pong.models.position.Position;
import com.beyondtechnicallycorrect.pong.models.position.PositionFactory;
import com.google.inject.Inject;

final class TerminalWallFactoryImpl implements TerminalWallFactory {

	private final PositionFactory m_positionFactory;
	private final CollisionBehavioursFactory m_collisionBehavioursFactory;
	
	@Inject
	public TerminalWallFactoryImpl(
			PositionFactory positionFactory,
			CollisionBehavioursFactory collisionBehavioursFactory
		) {
		
		m_positionFactory = positionFactory;
		m_collisionBehavioursFactory = collisionBehavioursFactory;
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
		
		CollisionBehaviours cb = m_collisionBehavioursFactory.create();
		
		TerminalWall wall = new TerminalWallImpl(pos, player, cb);
		return wall;
	}

}
