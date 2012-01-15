package com.beyondtechnicallycorrect.pong.models.paddle;

import com.beyondtechnicallycorrect.pong.models.collision.MutableOnCollision;
import com.beyondtechnicallycorrect.pong.models.placeable.Overlappable;
import com.beyondtechnicallycorrect.pong.models.velocity.Movable;

interface InternalPaddle extends MutableOnCollision, Overlappable, Movable {

}
