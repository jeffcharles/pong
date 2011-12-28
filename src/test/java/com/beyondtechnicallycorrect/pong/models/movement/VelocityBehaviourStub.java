package com.beyondtechnicallycorrect.pong.models.movement;

import com.beyondtechnicallycorrect.pong.models.velocity.VelocityBehaviour;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityResult;

final class VelocityBehaviourStub implements VelocityBehaviour {
	
	private final int m_xAmountToMove;
	private final int m_yAmountToMove;
	private final int m_xAmountToUnMove;
	private final int m_yAmountToUnMove;
	
	public VelocityBehaviourStub(
			int xAmountToMove,
			int yAmountToMove,
			int xAmountToUnMove,
			int yAmountToUnMove
		) {
		
		m_xAmountToMove = xAmountToMove;
		m_yAmountToMove = yAmountToMove;
		m_xAmountToUnMove = xAmountToUnMove;
		m_yAmountToUnMove = yAmountToUnMove;
	}

	@Override
	public VelocityResult move() {
		return new VelocityResult(m_xAmountToMove, m_yAmountToMove);
	}

	@Override
	public VelocityResult unMove() {
		return new VelocityResult(m_xAmountToUnMove, m_yAmountToUnMove);
	}

}
