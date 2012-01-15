package com.beyondtechnicallycorrect.pong.models.paddle;

import com.beyondtechnicallycorrect.pong.models.collision.AdjustVelocityDelegate;

final class WallCollisionAdjustVelocityDelegate implements
		AdjustVelocityDelegate {

	@Override
	public int getAdjustedAmountToMove(int amountToMove) {
		return 0;
	}

}
