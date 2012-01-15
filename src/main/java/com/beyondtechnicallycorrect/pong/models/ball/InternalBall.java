package com.beyondtechnicallycorrect.pong.models.ball;

import com.beyondtechnicallycorrect.pong.models.collision.MutableOnCollision;
import com.beyondtechnicallycorrect.pong.models.placeable.Overlappable;
import com.beyondtechnicallycorrect.pong.models.velocity.Movable;

interface InternalBall extends MutableOnCollision, Overlappable, Movable {

}
