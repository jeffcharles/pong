package com.beyondtechnicallycorrect.pong.models.ball;

import static org.mockito.Mockito.*;

import junit.framework.Assert;

import org.junit.Test;

import com.beyondtechnicallycorrect.pong.models.collision.AdjustVelocityDelegate;
import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;
import com.beyondtechnicallycorrect.pong.models.wall.Wall;

public final class TestWallCollisionBehaviour {
	
	@Test
	public void testGetTypeCollidedWith() {
		com.beyondtechnicallycorrect.pong.models.collision.WallCollisionBehaviour cb =
				new WallCollisionBehaviourStub();
		AdjustVelocityDelegate del = new AdjustVelocityDelegateStub();
		InternalBall ball = new InternalBallStub();
		WallCollisionBehaviour wcb = new WallCollisionBehaviour(cb, del, ball);
		Assert.assertEquals(Wall.class, wcb.getTypeCollidedWith());
	}
	
	@Test
	public void testCollide() {
		com.beyondtechnicallycorrect.pong.models.collision.WallCollisionBehaviour cb =
				mock(com.beyondtechnicallycorrect.pong.models.collision.WallCollisionBehaviour.class);
		AdjustVelocityDelegate del = new AdjustVelocityDelegateStub();
		InternalBall ball = new InternalBallStub();
		WallCollisionBehaviour wcb = new WallCollisionBehaviour(cb, del, ball);
		Placeable model = new PlaceableStub();
		
		wcb.collide(model);
		
		verify(cb).collide(ball, model, del);
	}

}
