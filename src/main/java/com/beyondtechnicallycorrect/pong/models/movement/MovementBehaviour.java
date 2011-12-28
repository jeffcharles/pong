package com.beyondtechnicallycorrect.pong.models.movement;

import com.beyondtechnicallycorrect.pong.models.position.Position;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityBehaviour;

public interface MovementBehaviour {
	
	Position move(Position startingPosition, VelocityBehaviour velocity);
	Position unMove(Position endingPosition, VelocityBehaviour velocity);

}
