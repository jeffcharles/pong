package com.beyondtechnicallycorrect.pong.models.collision;

import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityInfo;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityInfoChangable;

public interface MutableOnCollision extends Placeable, VelocityInfo,
		VelocityInfoChangable {

}
