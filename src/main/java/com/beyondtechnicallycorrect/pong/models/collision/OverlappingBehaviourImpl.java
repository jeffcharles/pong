package com.beyondtechnicallycorrect.pong.models.collision;

import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;
import com.beyondtechnicallycorrect.pong.models.position.*;

final class OverlappingBehaviourImpl implements OverlappingBehaviour {

	private final PositionFactory m_positionFactory;
	
	public OverlappingBehaviourImpl(
			PositionFactory positionFactory
		) {
		
		m_positionFactory = positionFactory;
	}
	
	@Override
	public boolean isOverlap(Placeable model, Position pos) {
		int x1 = model.getX1();
		int x2 = model.getX2();
		int y1 = model.getY1();
		int y2 = model.getY2();
		Position placeablePos = m_positionFactory.create(x1, x2, y1, y2);
		boolean overlap = placeablePos.isOverlapping(pos);
		return overlap;
	}

}
