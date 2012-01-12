package com.beyondtechnicallycorrect.pong.models.paddle;

import com.beyondtechnicallycorrect.pong.models.position.Position;

public interface PaddleFactory {
	
	public Paddle create(
			PaddleInstructionGetter instruction,
			Position position
		);

}
