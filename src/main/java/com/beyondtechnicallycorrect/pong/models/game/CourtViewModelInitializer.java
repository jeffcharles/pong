package com.beyondtechnicallycorrect.pong.models.game;

import com.beyondtechnicallycorrect.pong.models.collision.Collidable;
import com.beyondtechnicallycorrect.pong.models.collision.MovableCollidable;

interface CourtViewModelInitializer {
	
	public void initialize(
			MovableCollidable playerPaddle,
			MovableCollidable opponentPaddle,
			MovableCollidable ball,
			Iterable<Collidable> walls,
			Iterable<Collidable> terminalWalls
		);

}
