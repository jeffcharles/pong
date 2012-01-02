package com.beyondtechnicallycorrect.pong.models.wall;

import com.beyondtechnicallycorrect.pong.models.position.Position;

final class WallImpl implements Wall {
	
	private final Position m_position;
	
	public WallImpl(
			Position pos
		) {
		
		m_position = pos;
	}

	@Override
	public int getX1() {
		return m_position.getX1();
	}

	@Override
	public int getX2() {
		return m_position.getX2();
	}

	@Override
	public int getY1() {
		return m_position.getY1();
	}

	@Override
	public int getY2() {
		return m_position.getY2();
	}

}
