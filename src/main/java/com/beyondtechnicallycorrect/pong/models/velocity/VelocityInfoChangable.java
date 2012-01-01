package com.beyondtechnicallycorrect.pong.models.velocity;

public interface VelocityInfoChangable {
	
	public void setVelocity(
			int xAmountToMove,
			int xFramesPerMove,
			int yAmountToMove,
			int yFramesPerMove
		);

}
