package com.beyondtechnicallycorrect.pong.models.terminalwall;

import com.beyondtechnicallycorrect.pong.models.player.Player;
import com.beyondtechnicallycorrect.pong.models.position.Position;
import com.beyondtechnicallycorrect.pong.models.position.PositionFactory;
import com.google.inject.Inject;

final class TerminalWallFactoryImpl implements TerminalWallFactory {

	private final PositionFactory m_positionFactory;
	
	@Inject
	public TerminalWallFactoryImpl(
			PositionFactory positionFactory
		) {
		
		m_positionFactory = positionFactory;
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
		TerminalWall wall = new TerminalWallImpl(pos, player);
		return wall;
	}

}
