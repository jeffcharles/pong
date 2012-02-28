package com.beyondtechnicallycorrect.pong.models.game;

import com.beyondtechnicallycorrect.pong.models.collision.Collidable;
import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;

final class CollidableStub implements Collidable {
	
	private final int m_x1;
	private final int m_x2;
	private final int m_y1;
	private final int m_y2;
	
	public CollidableStub(
			int x1
		) {
		
		m_x1 = x1;
		m_x2 = 0;
		m_y1 = 0;
		m_y2 = 0;
	}
	
	public CollidableStub(
			int x1,
			int x2,
			int y1,
			int y2
		) {
		
		m_x1 = x1;
		m_x2 = x2;
		m_y1 = y1;
		m_y2 = y2;
	}

	@Override
	public int getX1() {
		return m_x1;
	}

	@Override
	public int getX2() {
		return m_x2;
	}

	@Override
	public int getY1() {
		return m_y1;
	}

	@Override
	public int getY2() {
		return m_y2;
	}

	@Override
	public void collide(Placeable objectCollidedWith) {
		// TODO Auto-generated method stub
		
	}

}
