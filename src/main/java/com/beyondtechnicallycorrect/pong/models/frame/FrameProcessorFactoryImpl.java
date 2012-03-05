package com.beyondtechnicallycorrect.pong.models.frame;

import java.util.ArrayList;
import java.util.Collection;

import com.beyondtechnicallycorrect.pong.models.collision.Collidable;
import com.beyondtechnicallycorrect.pong.models.collision.MovableCollidable;

public class FrameProcessorFactoryImpl implements FrameProcessorFactory {

	@Override
	public FrameProcessor create(
			MovableCollidable playerPaddle,
			MovableCollidable opponentPaddle,
			MovableCollidable ball,
			Iterable<Collidable> walls,
			Iterable<Collidable> terminalWalls
		) {

		Collection<FrameElement> movers = new ArrayList<FrameElement>();
		FrameElement playerPaddleElem = new FrameElementImpl(playerPaddle);
		movers.add(playerPaddleElem);
		FrameElement opponentPaddleElem = new FrameElementImpl(opponentPaddle);
		movers.add(opponentPaddleElem);
		FrameElement ballElem = new FrameElementImpl(ball);
		movers.add(ballElem);
		
		Collection<FrameElement> nonMovers = new ArrayList<FrameElement>();
		for(Collidable wall : walls) {
			FrameElement wallElem = new FrameElementImpl(wall);
			nonMovers.add(wallElem);
		}
		for(Collidable terminalWall : terminalWalls) {
			FrameElement terminalWallElem = new FrameElementImpl(terminalWall);
			nonMovers.add(terminalWallElem);
		}
		
		FrameProcessor processor = new FrameProcessorImpl(
				movers,
				nonMovers
			);
		
		return processor;
	}

}
