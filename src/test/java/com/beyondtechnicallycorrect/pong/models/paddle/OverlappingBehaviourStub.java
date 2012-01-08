package com.beyondtechnicallycorrect.pong.models.paddle;

import com.beyondtechnicallycorrect.pong.models.placeable.OverlappingBehaviour;
import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;
import com.beyondtechnicallycorrect.pong.models.position.Position;

final class OverlappingBehaviourStub implements OverlappingBehaviour {

	private final boolean m_isOverlapping;
	
	public OverlappingBehaviourStub(
			boolean isOverlapping
		) {
		
		m_isOverlapping = isOverlapping;
	}
	
	@Override
	public boolean isOverlap(Placeable model, Position pos) {
		return m_isOverlapping;
	}

}
