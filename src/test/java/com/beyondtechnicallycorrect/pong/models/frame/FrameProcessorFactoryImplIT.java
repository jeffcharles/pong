package com.beyondtechnicallycorrect.pong.models.frame;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;

import com.beyondtechnicallycorrect.pong.models.collision.Collidable;
import com.beyondtechnicallycorrect.pong.models.collision.MovableCollidable;

public final class FrameProcessorFactoryImplIT {
	
	@Test
	public void create_ShouldReturnNonNullFrameProcessor() {
		FrameProcessorFactory factory = new FrameProcessorFactoryImpl();
		
		MovableCollidable playerPaddle = new MovableCollidableStub();
		MovableCollidable opponentPaddle = new MovableCollidableStub();
		MovableCollidable ball = new MovableCollidableStub();
		Collection<Collidable> walls = new ArrayList<Collidable>();
		Collidable leftWall = new CollidableStub();
		walls.add(leftWall);
		Collidable rightWall = new CollidableStub();
		walls.add(rightWall);
		Collection<Collidable> terminalWalls = new ArrayList<Collidable>();
		Collidable topTerminalWall = new CollidableStub();
		terminalWalls.add(topTerminalWall);
		Collidable bottomTerminalWall = new CollidableStub();
		terminalWalls.add(bottomTerminalWall);
		
		FrameProcessor processor = factory.create(
				playerPaddle,
				opponentPaddle,
				ball,
				walls,
				terminalWalls
			);
		
		Assert.assertNotNull(processor);
	}

}
