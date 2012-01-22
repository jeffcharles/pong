package com.beyondtechnicallycorrect.pong.models.ball;

import junit.framework.Assert;

import org.junit.Test;

import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehaviour;
import com.beyondtechnicallycorrect.pong.models.terminalwall.TerminalWall;

public final class TestTerminalWallCollisionBehaviour {
	
	@Test
	public void testGetTypeCollidedWith() {
		InternalBall ball = new InternalBallStub();
		CollisionBehaviour<TerminalWall> twcb =
				new TerminalWallCollisionBehaviour(ball);
		Assert.assertEquals(TerminalWall.class, twcb.getTypeCollidedWith());
	}
	
	@Test
	public void testCollide_ShouldSetVelocityToZero() {
		InternalBallStub ball = new InternalBallStub(1, 1, 1, 1, 1, 1, 1, 1);
		TerminalWall wall = new TerminalWallStub(0, 2, 2, 2);
		CollisionBehaviour<TerminalWall> twcb =
				new TerminalWallCollisionBehaviour(ball);
		
		twcb.collide(wall);
		
		Assert.assertTrue(
				"Set velocity should have been called",
				ball.getSetVelocityCalled());
		Assert.assertEquals(
				"X velocity amount should be zero",
				0, ball.getSetVelocityXAmountArg());
		Assert.assertEquals(
				"Y velocity amount should be zero",
				0, ball.getSetVelocityYAmountArg());
	}

}
