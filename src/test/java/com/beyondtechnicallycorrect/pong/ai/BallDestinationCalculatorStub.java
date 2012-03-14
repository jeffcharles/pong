package com.beyondtechnicallycorrect.pong.ai;

import com.beyondtechnicallycorrect.pong.models.game.MovableElement;

final class BallDestinationCalculatorStub implements BallDestinationCalculator {
	
	private final int m_destinationToReturn;
	
	public BallDestinationCalculatorStub() {
		m_destinationToReturn = -1;
	}
	
	public BallDestinationCalculatorStub(int destinationToReturn) {
		m_destinationToReturn = destinationToReturn;
	}

	@Override
	public int getXPositionOfBallDestination(
			int courtWidth,
			int wallThickness,
			int paddleY1,
			MovableElement ball
		) {
		
		return m_destinationToReturn;
	}

}
