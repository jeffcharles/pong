package com.beyondtechnicallycorrect.pong.ai;

import com.beyondtechnicallycorrect.pong.models.game.MovableElement;

interface BallDestinationCalculator {
	
	public int getXPositionOfBallDestination(
			int courtWidth,
			int wallThickness,
			int paddleY1,
			MovableElement ball
		);

}
