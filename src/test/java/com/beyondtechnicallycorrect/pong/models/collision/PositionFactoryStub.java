package com.beyondtechnicallycorrect.pong.models.collision;

import com.beyondtechnicallycorrect.pong.models.position.Position;

final class PositionFactoryStub implements
		com.beyondtechnicallycorrect.pong.models.position.PositionFactory {
	
	private final boolean m_isOverlapping;
	
	public PositionFactoryStub(
			boolean isOverlapping
		) {
		
		m_isOverlapping = isOverlapping;
	}

	@Override
	public Position create(int x1, int x2, int y1, int y2) {
		return new PositionStub(m_isOverlapping);
	}

}
