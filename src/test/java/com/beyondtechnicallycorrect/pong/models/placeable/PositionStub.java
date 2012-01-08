package com.beyondtechnicallycorrect.pong.models.placeable;

import com.beyondtechnicallycorrect.pong.models.position.Position;

final class PositionStub implements Position {
	
	private final boolean m_isOverlapping;
	
	public PositionStub(
			boolean isOverlapping
		) {
		
		m_isOverlapping = isOverlapping;
	}

	@Override
	public int getX1() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getX2() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY1() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY2() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isOverlapping(Position position) {
		return m_isOverlapping;
	}

}
