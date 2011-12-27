package com.beyondtechnicallycorrect.pong.models.velocity;

final class DirectionalVelocity {

	private final DirectionalVelocityInfo m_velocityInfo;
	private int m_framesToNextMove;
	
	public DirectionalVelocity(
			DirectionalVelocityInfo velocityInfo
		) {
		
		m_velocityInfo = velocityInfo;
		m_framesToNextMove = 0;
	}
	
	public int getAmountToMove() {
		return m_velocityInfo.getAmountToMove();
	}
	
	public int getFramesPerMove() {
		return m_velocityInfo.getFramesPerMove();
	}
	
	/**
	 * Returns how much to move for this frame
	 * @return The amount of movement for this frame
	 */
	public int move() {
		if(m_framesToNextMove > 0) {
			m_framesToNextMove--;
			return 0;
		}
		m_framesToNextMove = m_velocityInfo.getFramesPerMove() - 1;
		return m_velocityInfo.getAmountToMove();
	}
	
	/**
	 * Reverses a move() and returns what move() did but negated
	 * @return The amount of movement to reverse the last move()
	 */
	public int unMove() {
		if(m_framesToNextMove < m_velocityInfo.getFramesPerMove() - 1) {
			m_framesToNextMove++;
			return 0;
		}
		m_framesToNextMove = 0;
		return -m_velocityInfo.getAmountToMove();
	}
}
