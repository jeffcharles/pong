package com.beyondtechnicallycorrect.pong.models.paddle;

import com.beyondtechnicallycorrect.pong.models.placeable.Overlappable;
import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;
import com.beyondtechnicallycorrect.pong.models.velocity.Movable;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityInfo;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityInfoChangable;

interface InternalPaddle extends Placeable, Overlappable, Movable, VelocityInfo,
		VelocityInfoChangable {

}
