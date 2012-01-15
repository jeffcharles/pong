package com.beyondtechnicallycorrect.pong.models.ball;

import com.beyondtechnicallycorrect.pong.models.collision.AdjustVelocityDelegate;

final class WallCollisionAdjustVelocityDelegate implements
		AdjustVelocityDelegate {

	@Override
	public int getAdjustedAmountToMove(int amountToMove) {
		return -amountToMove;
	}

}
