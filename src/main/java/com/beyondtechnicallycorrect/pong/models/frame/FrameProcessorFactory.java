package com.beyondtechnicallycorrect.pong.models.frame;

import com.beyondtechnicallycorrect.pong.models.collision.Collidable;
import com.beyondtechnicallycorrect.pong.models.collision.MovableCollidable;

interface FrameProcessorFactory {
	
	public FrameProcessor create(
			MovableCollidable playerPaddle,
			MovableCollidable opponentPaddle,
			MovableCollidable ball,
			Iterable<Collidable> walls,
			Iterable<Collidable> terminalWalls
		);

}
