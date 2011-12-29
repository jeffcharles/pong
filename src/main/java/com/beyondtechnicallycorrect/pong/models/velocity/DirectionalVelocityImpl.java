package com.beyondtechnicallycorrect.pong.models.velocity;

final class DirectionalVelocityImpl implements DirectionalVelocity {

	private final DirectionalVelocityInfo m_velocityInfo;
	private int m_framesToNextMove;
	
	public DirectionalVelocityImpl(
			DirectionalVelocityInfo velocityInfo
		) {
		
		m_velocityInfo = velocityInfo;
		m_framesToNextMove = 0;
	}
	
	/* (non-Javadoc)
	 * @see com.beyondtechnicallycorrect.pong.models.velocity.DirectionalVelocity#getAmountToMove()
	 */
	@Override
	public int getAmountToMove() {
		return m_velocityInfo.getAmountToMove();
	}
	
	/* (non-Javadoc)
	 * @see com.beyondtechnicallycorrect.pong.models.velocity.DirectionalVelocity#getFramesPerMove()
	 */
	@Override
	public int getFramesPerMove() {
		return m_velocityInfo.getFramesPerMove();
	}
	
	/* (non-Javadoc)
	 * @see com.beyondtechnicallycorrect.pong.models.velocity.DirectionalVelocity#move()
	 */
	@Override
	public int move() {
		if(m_framesToNextMove > 0) {
			m_framesToNextMove--;
			return 0;
		}
		m_framesToNextMove = m_velocityInfo.getFramesPerMove() - 1;
		return m_velocityInfo.getAmountToMove();
	}
	
	/* (non-Javadoc)
	 * @see com.beyondtechnicallycorrect.pong.models.velocity.DirectionalVelocity#unMove()
	 */
	@Override
	public int unMove() {
		if(m_framesToNextMove < m_velocityInfo.getFramesPerMove() - 1) {
			m_framesToNextMove++;
			return 0;
		}
		m_framesToNextMove = 0;
		return -m_velocityInfo.getAmountToMove();
	}
}
