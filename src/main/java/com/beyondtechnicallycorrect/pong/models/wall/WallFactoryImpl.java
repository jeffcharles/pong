package com.beyondtechnicallycorrect.pong.models.wall;

import com.beyondtechnicallycorrect.pong.models.position.Position;
import com.beyondtechnicallycorrect.pong.models.position.PositionFactory;
import com.google.inject.Inject;

final class WallFactoryImpl implements WallFactory {
	
	private final PositionFactory m_positionFactory;
	
	@Inject
	public WallFactoryImpl(
			PositionFactory positionFactory
		) {
		
		m_positionFactory = positionFactory;
	}

	@Override
	public Wall create(
			int x1,
			int x2,
			int y1,
			int y2
		) {
		
		Position pos = m_positionFactory.create(x1, x2, y1, y2);
		Wall wall = new WallImpl(pos);
		return wall;
	}

}
