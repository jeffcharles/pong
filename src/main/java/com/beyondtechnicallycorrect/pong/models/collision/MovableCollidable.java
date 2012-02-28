package com.beyondtechnicallycorrect.pong.models.collision;

import com.beyondtechnicallycorrect.pong.models.placeable.Overlappable;
import com.beyondtechnicallycorrect.pong.models.velocity.Movable;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityInfo;

public interface MovableCollidable extends Collidable, Movable, Overlappable, VelocityInfo {
	
}
