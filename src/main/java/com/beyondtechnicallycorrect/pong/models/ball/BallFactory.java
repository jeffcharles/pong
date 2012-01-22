package com.beyondtechnicallycorrect.pong.models.ball;

import com.beyondtechnicallycorrect.pong.models.position.Position;
import com.beyondtechnicallycorrect.pong.models.velocity.Velocity;

public interface BallFactory {
	
	public Ball create(
			Position position,
			Velocity velocity
		);

}
