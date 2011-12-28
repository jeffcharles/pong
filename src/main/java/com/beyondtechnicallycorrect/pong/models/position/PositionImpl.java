package com.beyondtechnicallycorrect.pong.models.position;

final class PositionImpl implements Position {

	private final int m_x1;
	private final int m_x2;
	private final int m_y1;
	private final int m_y2;
	
	/**
	 * @param x1 Must be greater than or equal to 0 and less than x2
	 * @param x2 Must be greater than or equal to 0 and greater than x1
	 * @param y1 Must be greater than or equal to 0 and less than y2 
	 * @param y2 Must be greater than or equal to 0 and greater than y1
	 */
	public PositionImpl(
			int x1,
			int x2,
			int y1,
			int y2
		) {
		
		if(x1 < 0 || x2 < 0 || y1 < 0 || y2 < 0) {
			throw new IllegalArgumentException("Arguments cannot be less than 0");
		}
		
		if(x2 <= x1) {
			throw new IllegalArgumentException("X2 must be greater than X1");
		}
		
		if(y2 <= y1) {
			throw new IllegalArgumentException("Y2 must be greater than Y1");
		}
		
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
	public boolean isOverlapping(
			com.beyondtechnicallycorrect.pong.models.position.Position position) {
		
		final int otherX1 = position.getX1();
		final int otherX2 = position.getX2();
		final int otherY1 = position.getY1();
		final int otherY2 = position.getY2();
		
		// both a Y point and an X point need to overlap
		// run a couple light-weight checks to fail fast (the common case)
		
		boolean xCannotOverlap = otherX1 > m_x2 || otherX2 < m_x1;
		if(xCannotOverlap) {
			return false;
		}
		
		boolean yCannotOverlap = otherY1 > m_y2 || otherY2 < m_y1;
		if(yCannotOverlap) {
			return false;
		}
		
		boolean overlappingX =
				(otherX1 >= m_x1 && otherX1 <= m_x2) ||
				(otherX2 >= m_x1 && otherX2 <= m_x2) ||
				(m_x1 >= otherX1 && m_x1 <= otherX2) ||
				(m_x2 >= otherX1 && m_x2 <= otherX2);
		
		if(!overlappingX) {
			return false;
		}
		
		boolean overlappingY =
				(otherY1 >= m_y1 && otherY1 <= m_y2) ||
				(otherY2 >= m_y2 && otherY2 <= m_y2) ||
				(m_y1 >= otherY1 && m_y1 <= otherY2) ||
				(m_y2 >= otherY1 && m_y2 <= otherY2);
		
		return overlappingY;
	}

}
