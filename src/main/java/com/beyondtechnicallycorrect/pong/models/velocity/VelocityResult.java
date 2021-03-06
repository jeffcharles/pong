package com.beyondtechnicallycorrect.pong.models.velocity;

public final class VelocityResult {
	
	private final int m_xAmountMoved;
	private final int m_yAmountMoved;
	
	public VelocityResult(
			int xAmountMoved,
			int yAmountMoved
		) {
		
		m_xAmountMoved = xAmountMoved;
		m_yAmountMoved = yAmountMoved;
	}

	public int getXAmountMoved() {
		return m_xAmountMoved;
	}
	
	public int getYAmountMoved() {
		return m_yAmountMoved;
	}
	
}
