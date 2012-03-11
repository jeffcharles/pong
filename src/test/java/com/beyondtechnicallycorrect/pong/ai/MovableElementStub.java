package com.beyondtechnicallycorrect.pong.ai;

import com.beyondtechnicallycorrect.pong.models.game.MovableElement;

class MovableElementStub implements MovableElement {
	
	private final int m_x1;
	private final int m_x2;
	
	public MovableElementStub(int x1, int x2) {
		m_x1 = x1;
		m_x2 = x2;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY2() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getXVelocity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getYVelocity() {
		// TODO Auto-generated method stub
		return 0;
	}

}
