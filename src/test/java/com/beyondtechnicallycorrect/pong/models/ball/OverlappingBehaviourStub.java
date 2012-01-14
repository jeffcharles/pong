package com.beyondtechnicallycorrect.pong.models.ball;

import com.beyondtechnicallycorrect.pong.models.placeable.OverlappingBehaviour;
import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;
import com.beyondtechnicallycorrect.pong.models.position.Position;

final class OverlappingBehaviourStub implements OverlappingBehaviour {

	private final boolean m_isOverlap;
	
	public OverlappingBehaviourStub(
			boolean isOverlap
		) {
		
		m_isOverlap = isOverlap;
	}
	
	@Override
	public boolean isOverlap(Placeable model, Position pos) {
		return m_isOverlap;
	}

}
