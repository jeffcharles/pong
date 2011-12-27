package com.beyondtechnicallycorrect.pong.models.velocity;

final class DirectionalVelocityInfo {

	private final int m_amountToMove;
	private final int m_framesPerMove;
	
	public DirectionalVelocityInfo(
			int amountToMove,
			int framesPerMove
		) {
		
		if(framesPerMove < 1) {
			throw new IllegalArgumentException(
					"framesBetweenMovement must be greater than or equal to 1");
		}
		
		m_amountToMove = amountToMove;
		m_framesPerMove = framesPerMove;
	}
	
	public int getAmountToMove() {
		return m_amountToMove;
	}
	
	public int getFramesPerMove() {
		return m_framesPerMove;
	}
	
}
