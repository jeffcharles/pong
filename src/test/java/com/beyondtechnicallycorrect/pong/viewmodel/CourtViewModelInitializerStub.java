package com.beyondtechnicallycorrect.pong.viewmodel;

import com.beyondtechnicallycorrect.pong.models.collision.Collidable;
import com.beyondtechnicallycorrect.pong.models.collision.MovableCollidable;
import com.beyondtechnicallycorrect.pong.models.game.CourtViewModelInitializer;

final class CourtViewModelInitializerStub implements CourtViewModelInitializer {

	@Override
	public void initialize(MovableCollidable playerPaddle,
			MovableCollidable opponentPaddle, MovableCollidable ball,
			Iterable<Collidable> walls, Iterable<Collidable> terminalWalls) {
		// TODO Auto-generated method stub

	}

}
