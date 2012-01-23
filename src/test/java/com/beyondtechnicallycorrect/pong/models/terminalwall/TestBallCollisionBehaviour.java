package com.beyondtechnicallycorrect.pong.models.terminalwall;

import static org.mockito.Mockito.*;

import junit.framework.Assert;

import org.junit.Test;

import com.beyondtechnicallycorrect.pong.models.ball.Ball;
import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehaviour;
import com.beyondtechnicallycorrect.pong.models.game.MatchStatePublisher;
import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;
import com.beyondtechnicallycorrect.pong.models.player.Player;

public final class TestBallCollisionBehaviour {
	
	@Test
	public void testGetTypeCollidedWith() {
		InternalTerminalWall internalTerminalWall =
				new InternalTerminalWallStub();
		MatchStatePublisher publisher = new MatchStatePublisherStub();
		CollisionBehaviour<Ball> cb =
				new BallCollisionBehaviour(internalTerminalWall, publisher);
		Assert.assertEquals(Ball.class, cb.getTypeCollidedWith());
	}
	
	@Test
	public void testCollide_ShouldPublishMatchEnding() {
		Player player = new PlayerStub();
		InternalTerminalWall internalTerminalWall =
				new InternalTerminalWallStub(player);
		MatchStatePublisher publisher = mock(MatchStatePublisher.class);
		CollisionBehaviour<Ball> cb =
				new BallCollisionBehaviour(internalTerminalWall, publisher);
		
		Placeable model = new PlaceableStub();
		cb.collide(model);
		
		verify(publisher).publishMatchEnding(player);
	}

}
