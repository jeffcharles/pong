package com.beyondtechnicallycorrect.pong.models.ball;

import com.beyondtechnicallycorrect.pong.models.velocity.Velocity;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityFactory;

final class VelocityFactoryStub implements VelocityFactory {

	@Override
	public Velocity create(
			int xAmountToMove,
			int xFramesPerMove,
			int yAmountToMove,
			int yFramesPerMove
		) {
		
		return new VelocityStub(
				xAmountToMove, xFramesPerMove, yAmountToMove, yFramesPerMove);
	}

}
