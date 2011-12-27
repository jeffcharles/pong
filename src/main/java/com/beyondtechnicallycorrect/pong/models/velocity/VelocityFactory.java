package com.beyondtechnicallycorrect.pong.models.velocity;

public interface VelocityFactory {

	Velocity create(
			int xAmountToMove,
			int xFramesPerMove,
			int yAmountToMove,
			int yFramesPerMove
		);
	
}
