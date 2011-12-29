package com.beyondtechnicallycorrect.pong.models.velocity;

final class DirectionalVelocityStub implements DirectionalVelocity {

	private final int m_amountToMove;
	private final int m_framesPerMove;
	private final int m_moveRetValue;
	private final int m_unMoveRetValue;
	
	public DirectionalVelocityStub(
			int amountToMove,
			int framesPerMove,
			int moveRetValue,
			int unMoveRetValue
		) {
		
		m_amountToMove = amountToMove;
		m_framesPerMove = framesPerMove;
		m_moveRetValue = moveRetValue;
		m_unMoveRetValue = unMoveRetValue;
	}
	
	@Override
	public int getAmountToMove() {
		return m_amountToMove;
	}

	@Override
	public int getFramesPerMove() {
		return m_framesPerMove;
	}

	@Override
	public int move() {
		return m_moveRetValue;
	}

	@Override
	public int unMove() {
		return m_unMoveRetValue;
	}

}
