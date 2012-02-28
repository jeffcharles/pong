package com.beyondtechnicallycorrect.pong.models.game;

final class MovableElementStub implements MovableElement {
	
	private final int m_x1;
	
	public MovableElementStub() {
		m_x1 = 0;
	}
	
	public MovableElementStub(
			int x1
		) {
		
		m_x1 = x1;
	}

	@Override
	public int getX1() {
		return m_x1;
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
