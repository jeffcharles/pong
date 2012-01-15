package com.beyondtechnicallycorrect.pong.models.collision;

final class AdjustVelocityDelegateStub implements AdjustVelocityDelegate {

	private final int m_amountToReturn;
	
	public AdjustVelocityDelegateStub(
			int amountToReturn
		) {
		
		m_amountToReturn = amountToReturn;
	}
	
	@Override
	public int getAdjustedAmountToMove(int amountToMove) {
		return m_amountToReturn;
	}

}
