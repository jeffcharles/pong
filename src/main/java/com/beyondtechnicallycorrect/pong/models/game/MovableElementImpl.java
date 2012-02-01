package com.beyondtechnicallycorrect.pong.models.game;

final class MovableElementImpl implements MovableElement {
	
	private final int m_x1;
	private final int m_x2;
	private final int m_y1;
	private final int m_y2;
	private final double m_xVelocity;
	private final double m_yVelocity;

	public MovableElementImpl(
			int x1,
			int x2,
			int y1,
			int y2,
			double xVelocity,
			double yVelocity
		) {
		
		m_x1 = x1;
		m_x2 = x2;
		m_y1 = y1;
		m_y2 = y2;
		m_xVelocity = xVelocity;
		m_yVelocity = yVelocity;
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
	public double getXVelocity() {
		return m_xVelocity;
	}

	@Override
	public double getYVelocity() {
		return m_yVelocity;
	}

}
