package com.beyondtechnicallycorrect.pong.models.ball;

import com.beyondtechnicallycorrect.pong.models.placeable.Overlappable;
import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;
import com.beyondtechnicallycorrect.pong.models.velocity.Movable;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityInfo;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityInfoChangable;

interface InternalBall extends Placeable, Overlappable, Movable, VelocityInfo,
		VelocityInfoChangable {

}
